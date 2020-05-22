else if(source == searchMI) {
    String searchName = JOptionPane.showInputDialog(this,
            "Please enter a name (last first) to search:");
    System.out.println("Name to search: " + searchName);
    String name;
    for(int i=0; i < nameList.getItemCount(); i++){
        name = nameList.getItem(i);
        if(name.equalsIgnoreCase(searchName)){
            nameList.select(i);
                //add this code for display data:
            String[] n = name.split(" ");
            firstName.setText(n[0]);
            lastName.setText(n[1]);
            phoneNumber.setText(numberList.getItem(i));
                //end
            System.out.println("We Found Him");
        }
    }
}