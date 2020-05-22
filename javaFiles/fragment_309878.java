public void searchAndShow(String name) {
    for (int i = 0; i < arraylist.size(); i++) {
        favoriteshow fs = arraylist.get(i);
        if (fs.getName().equals(name)) {
            System.out.println(i + " - " + fs);
    }   
}