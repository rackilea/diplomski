public void doLoad() throws Exception {
    if (length != 0) {
        //throw new Exception ("I'm not empty"); 
        //File c = new File ("contacts.txt");//No need to access the File here..
        Scanner input = new Scanner(c);
        while (input.hasNextLine()) {
            Entry e = new Entry();
            e.name = input.next();
            if ("q".equalsIgnorecase(e.name))
            break;
            e.number = input.next();
            e.notes = input.next();
            doAddEntry(e);
        }
        doAddEntry(null);
    }   
}