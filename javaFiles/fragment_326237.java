public class MainClass {

public static void main(String[] args) {

Foo f1 = new Foo();
f1.setNameFoo("tony");
f1.setNumberOfFoo(100);
Foo f2 = new Foo();
f2.setNameFoo("tony");
f2.setNumberOfFoo(200);
Foo f3 = new Foo();
f3.setNameFoo("cap");
f3.setNumberOfFoo(500);
List<Foo> l = Arrays.asList(f1,f2,f3);
Map<String,List<Foo>> m = new HashMap<>();
List<Foo> result = new ArrayList<>();
for(Foo f:l) {
    if(m.get(f.getNameFoo())==null) {
        List<Foo> templist = new ArrayList<>();
        templist.add(f);
        m.put(f.getNameFoo(), templist);
    }else {
        List<Foo> list =m.get(f.getNameFoo());
        list.add(f);
        m.put(f.getNameFoo(), list);
    }
}
for(String s : m.keySet()) {
    Foo fin = new Foo();
    Integer fooNumber =0;
    for(Foo foo : m.get(s)) {
        fooNumber = fooNumber+Integer.valueOf(foo.getNumberOfFoo());
        fin.setNameFoo(foo.getNameFoo());
        fin.setNumberOfFoo(fooNumber.toString());
    }
    result.add(fin);
}
System.out.println(result); //[Foo [nameFoo=tony, numberOfFoo=300], Foo [nameFoo=cap, numberOfFoo=500]]

  }
}