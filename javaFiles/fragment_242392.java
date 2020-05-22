public static int count;

...

public static int getCount() { //Follow Java conventions - use camelCase
    return count;
}

...

//In main
new Save(15);
Integer x = Save.getCount(); //1 instance