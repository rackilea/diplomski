class MyClass {
    // Note that it's bad practice to make fields public.
    // Also, you do not need to initialize fields to "" if you're going to initialize them in the constructor.
    private String stra;
    private String strb;

    public MyClass(String a, String b) {
        this.stra = a;
        this.strb = b;
    }

    public String getStra() {
        return stra;
    }

    public String getStrb() {
        return strb;
    }
}

MyClass myclassinst1 = new MyClass("blah","xxxx");
MyClass myclassinst2 = new MyClass("blah2","yyyy");
MyClass myclassinst3 = new MyClass("blah3","zzzz");

List<MyClass> mylist = new ArrayList<MyClass>();
mylist.add(myclassinst1);
mylist.add(myclassinst2);
mylist.add(myclassinst3);

List<String> list1 = new ArrayList<String>();
List<String> list2 = new ArrayList<String>();

for (MyClass obj : mylist) {
    list1.add(obj.getStra());
    list2.add(obj.getStrb());
}

String[] strarrA = list1.toArray(new String[list1.size()]);
String[] strarrB = list2.toArray(new String[list2.size()]);