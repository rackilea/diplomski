name = name == null ? "" : name.trim();
if(name.isEmpty()) {
    System.out.println("Null, empty, or white space only name received");
} else {
    System.out.println("Name with at least length one received");
    name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
}