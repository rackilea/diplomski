@Autowired
private GenericRepository<MyClass1> mc1Repository;
@Autowired
private GenericRepository<MyClass2> mc2Repository;

public void doStuff() {
    MyClass1 myClass1 = new MyClass1();
    myClass1.setText1("text1");
    mc1Repository.save(myClass1);
    mc1Repository.findAll(MyClass1.class).forEach(d -> System.out.println(d.getText1()));

    MyClass2 myClass2 = new MyClass2();
    myClass2.setText2("text2");
    mc2Repository.save(myClass2);
    mc2Repository.findAll(MyClass2.class).forEach(d -> System.out.println(d.getText2()));
}