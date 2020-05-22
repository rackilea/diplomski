if (custom.getUser().equals("0") || custom.getUser().isEmpty()) {
    vital.add(new Pair < String, String > ("User", "-"));
} else {
    // limit scope of variable to else-branch
    String name = ""; 
    // check empty string with isEmpty
    if (!custom.getName().isEmpty()) {
        name = custom.getName().substring(0, 1);
    }
    // add a new Pair in any case
    vital.add(new Pair < String, String > 
       ("User", custom.user() + "F" + "\n" + name));
}