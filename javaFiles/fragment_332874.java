ArrayList<String> al=new ArrayList<String>();
    //a1 is empty ArrayList of Strings.
    String str=new String("abc");
    //str is now a reference to "abc"
    al.add(str);
    //a1 has now reference to "abc"
    str="def";
    //str has now reference to "def"
    al.add(str);
    //a1 has now reference to "abc" and reference to "def"
    str="ghi";
    //str has now reference to "ghi"
    al.add(str);
    //a1 has now three different references
    str="jkl";
    //str has now reference to "jkl"
    al.add(str);
    //a1 has now four different references.
    System.out.println(al);

    ArrayList<MainClass> al1=new ArrayList<MainClass>();
    //al1 is now empty
    MainClass mainclass=new MainClass();
    //mainclass has now reference to an object with an empty String
    mainclass.setName("Abhi");
    //mainclass' reference didn't change. It's still the same, however the string is different
    al1.add(mainclass);
    //al1 has now one reference to the mainclass
    mainclass.setName("Sajith");
    //mainclass' reference didn't change. It's still the same, however the string is different
    al1.add(mainclass);
    //al1 has now two references to the mainclass
    mainclass.setName("Sridhar");
    //mainclass' reference didn't change. It's still the same, however the string is different
    al1.add(mainclass);
    //al1 has now three references to the mainclass

    for(MainClass main:al1)
        System.out.println(main.getName());