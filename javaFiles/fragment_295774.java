public void modify(String name) {
    for (Item i : item) {
        if (i.getName().equalsIgnoreCase(name)) {
            System.out.println("New name: ");
            String newName = in.nextLine();
            i.setName(newName);
        }
    }
}