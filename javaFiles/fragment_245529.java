Map<String, IAttack> attackMap = new HashMap<>();  // Assuming IAttack is an interface implemented by your classes
public MyClass() {
    attackMap.put("Foo", new Foo());
    attackMap.put("Bar", new Bar());
}

public void create(String x) {
  this.stuff = attackMap.get(x);
}