public Friendlies find(String name) {
    for(Friendlies friend : fr) {
        if(friend.getName().equalsIgnoreCase(name))
            return fiend;
    }
    return null;

}

//now to print the info you can do this:
Friendlies findJoe = find("Joe");
if(findJoe==null)
    System.out.println("You have no friends namd Joe.");
else
    System.out.println(findJoe);