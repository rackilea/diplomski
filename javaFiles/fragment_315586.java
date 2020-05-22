// in the else branch of the outermost if
boolean petFound = false; // note this line
input = input.toLowerCase();

for(Pet pet: h1.getPets()){

    String text1 = String.format("%s%10s%10s\n", "Namn:", "Mått:", "Sort:");
    String text2 = String.format("%s%10.2f%16s", pet.getName(), pet.measureFood(), pet.getFoodName());
    String text3 = "---------------------------------------\n";
    text1 = text1 + text3 + text2;


    if (pet.getName().toLowerCase().equals(input)) {
        JOptionPane.showMessageDialog(null,text1);
        petFound = true; // note this line
        break;
    }
}
if (!petFound) {
    // show the message that there is no pet with the input name
}