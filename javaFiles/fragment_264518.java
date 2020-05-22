int i = 0;  // Counter for the while cycle

while (!(lines[i].split("=")[0].equals("name"))) {
    i++;                      

    if (lines[i].split("=")[0].equals("name")){ // If the field is name...
        System.out.println(lines[i].split("=")[1]); // Prints the value of the field

        name = lines[i].split("=")[1]; // <-- My problem is here
    }
}