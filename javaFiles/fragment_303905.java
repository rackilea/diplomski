public void populateTable() {

        model = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };

        for(String name: columnNames)
            model.addColumn(name);
        ArrayList<Health> temp = new ArrayList<Health>();
        temp = health.showAllData();
        for(int i = 0; i< temp.size(); i++) {
            Object[] data = {temp.get(i).getZipCode(), temp.get(i).getCounty(), temp.get(i).getCounty(), temp.get(i).getState(),temp.get(i).getYear(),
                             temp.get(i).getMonth(), temp.get(i).getAgeGroup(), temp.get(i).getNumOfVisits(), temp.get(i).getMMax(), temp.get(i).getMMin(), temp.get(i).getMNor()};
            model.addRow(data);
        }
    }