for(Drug d: allDrugs)
{
    //finished here, makesure that the string that comes in from the name of the drug from the field is the same as the one already i nthe arraylist
    //Done by capitalising the first letter no matter what.
    if(d.getName().equalsIgnoreCase(searchField.getText()))
    {
         MainMenu.textArea.setText(null);
         MainMenu.textArea.append(d.allDetailsToString());
         MainMenu.textArea.setEditable(false);
         break;
    }
    //this will run for the first loop round and it will break the loop if the first item in list is not the search target
    JOptionPane.showMessageDialog(null, "Drug not found");
    break;

}