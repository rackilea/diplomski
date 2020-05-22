interface Base{
    void generateItem();
}
class Derived1 implements Base{
    @Override
    public void generateItem() {
        System.out.println("generateItem() from Derived1");
    }
}
class Derived2 implements Base{
    @Override
    public void generateItem() {
        System.out.println("generateItem() from Derived2");
    }
}
class Main {
    public static void main(String[] args) {
        List<Base> list = new ArrayList<>();
        list.add(new Derived1());
        list.add(new Derived2());
        list.forEach(Base::generateItem);
    }
}