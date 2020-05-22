String[] anArray;
String name;

// allocates memory for 10 integers
anArray = new String[4];      
// initialize first element
anArray[0] = "mike";
// initialize second element
anArray[1] = "Rice";
// and so forth
anArray[2] ="John";
anArray[3] = "Rice";

name = anArray[0]+","+ anArray[1];

System.out.println("Element at index 0: "
                   + name);