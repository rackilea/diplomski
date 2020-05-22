public void loadData (String sourceName){
    Scanner read = new Scanner(sourceName);
    int i = 1;

    while (read.hasNextLine()) {
        if(i%2 != 0)
            String name = read.nextLine();
        else
            String telno = read.nextLine(); //ArrayPhoneDirectory Line 42
        add(name, telno);
        i++;
    }
}