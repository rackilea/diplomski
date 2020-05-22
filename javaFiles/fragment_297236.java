String columns[] = {"Color", "Age", "Eats Grass?"}; 

DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

for (Animal animal : ani) {
    tableModel.addRow(animal.getDataArray());
}

JTable animalTable = new JTable(tableModel);