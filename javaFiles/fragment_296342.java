String file = "data.dat";
Scanner s = null;
try {
    s = new Scanner(new File(file)); //no more delimiter. It's not needed
    ArrayList<String> list = new ArrayList<String>();
    while (s.hasNextLine()) {

        String[] strings = s.nextLine().split("[||]");
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);   
        }
    }
    s.close();
    for (String string : list) {  //Lets print out the values of the list
        System.out.println(string);
    }
} catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}