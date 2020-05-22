...
Object[] arguments = new Object[constructors[constr].getParameterCount()];

Class<?>[] pTypes = constructors[constr].getParameterTypes();

for (int i = 0; i < arguments.length; i++) {
    System.out.println("Write argument #" + (i + 1) + ". Of type: "+pTypes[i].getName());

    if(pTypes[i].equals(int.class)) {               
        arguments[i] = keyboard.nextInt(); // read an int
    } else if(pTypes[i].equals(String.class)) {
        arguments[i] = keyboard.next(); // read a String
    } else {
        // custom read code for other types
    }
}
...