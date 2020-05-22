enum Color { RED, GREEN, BLUE }

// somewhere in your code
String colorName = "GREEN";
try {
    Color color = Color.valueOf(colorName);
} catch (IllegalArgumentException e){
    // colorName was not the name of a member of the enum
}