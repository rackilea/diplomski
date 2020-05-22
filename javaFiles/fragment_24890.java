public void actionPerformed(ActionEvent e) {     

        List<List<String>> model = new ArrayList<List<String>>(); 

        String ID = text1.getText();
        String PName = text2.getText();
        String Gender = text3.getText();
        String DoB = text4.getText();
        String Address = text5.getText();
        String phistry = text6.getText();

        List<String> line = Arrays.asList(new String[]{ID, PName, Gender, DoB, Address, phistry});
        model.add(line);

        StringBuilder sb = new StringBuilder();
        sb.append("ID\tFirst\tLast\tCourse\tYear\n");
        for(List<String> input : model) {
            for (String item : input) {
                sb.append(item);
                if (input.indexOf(item) == input.size()-1) {
                    sb.append("\n");
                } else {
                    sb.append("\t");
                }
            }
        }
        this.phistry.setText(sb.toString());//sets the text in tab1
        panel2.setModel(model);//sets the model in Doctors panel
    }