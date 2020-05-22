if (answer.hasMoreElements()) {
    while(answer.hasMoreElements()) {
        Person person = new Person();
        SearchResult  attrs = ((SearchResult) answer.next());
        String names[] = attrs.getName().split(",");
        String name[] = names[0].split("=");

        usersList.add(name[1]);
    }
}else{
    throw new Exception("Invalid User");
}