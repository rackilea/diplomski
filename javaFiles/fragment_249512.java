boolean allSelected = true;  //Initially set it to true which indicates that all selected values are other than 0
for (int i = 0; i < set.length; i++) {

    JComboBox boxes = set[i];
    int index = boxes.getSelectedIndex();

    if (index == 0) {    
        allSelected = false;  //If index is 0, make it false
    }
} 

if(allSelected)
{
    System.out.println("Every combobox has selected something"); 
}
else
{
    System.out.println("Not every JcomboBox has something selected"); 
}