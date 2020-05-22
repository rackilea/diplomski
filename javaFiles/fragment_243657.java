public String find(String searchName) {
    for (TelEntry entry : Directory.entries) {
        if (entry.name.equalsIgnoreCase(searchName)) {
            return entry.name + entry.telNo;
        }
    }
    System.out.println("sorry, there is noone by that name in the Directory. Check your spelling and try again");
    return null; // or return "searchName", the error message, or something else
}