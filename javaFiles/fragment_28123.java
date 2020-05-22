for (VirtualClass clazz : classes) {
    System.out.println((clazz.isPrivate ? "private" : "public") + " " + clazz.className);
}

// or something like

for (int i = 0; i < classes.size(); i++) {
    System.out.println(classes.get(i).className + ":");
    if (classes.get(i).isPrivate) {
        System.out.println(" private");
    } else {
        System.out.println(" public");
    }
}