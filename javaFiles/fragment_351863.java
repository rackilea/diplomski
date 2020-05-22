List<A> list = new ArrayList<A>();
list.add(new A());
list.add(new A());
list.add(new B());

public void printAll() {
    for(A i : list) {
        System.out.println(i.print());
    }
}

class A {
    public String print() {
        return "A";
    }
}

class B extends A {
    @Override
    public String print() {
        return"B";
    }
}