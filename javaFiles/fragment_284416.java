public static void main(String args[]) {
    String[] names = new String[4]; //I want to fill this up with data from country
    country(names);
    System.out.println(names[0]); //I want this to display Madrid
}

public static void country(String[] names) {
    names[0] = "Madrid";
    names[1] = "Berlin";
}