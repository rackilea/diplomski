class MyString {
    public String value;
    public MyString(String value) {
        this.value = value;
    }
}
MyString myStr = new MyString("some value");
list.add(myStr);
((MyString) list.get(0)).value = "a new value";
System.out.println(myStr.value); // will print "a new value"