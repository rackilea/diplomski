String[] elements = { "1", "studentA" };
ArrayList<String> list = new ArrayList<String>(Arrays.asList(elements));
Scanner sc = new Scanner(System.in);

while (true) {
    System.out.println("would you like to remove an id? if so type in "
            + "the id, otherwise type: no");        
    String input = sc.next();

    if ("no".equalsIgnoreCase(input)) {
        break; // exit the loop
    }

    if (list.remove(input)) {
        System.out.println("found and removed");
    } else {
        System.out.println("not found in list");
    }
}