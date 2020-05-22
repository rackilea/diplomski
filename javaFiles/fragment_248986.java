class Employees {

    String name;
    int age;
    int id ;
    static int counter = 0;

    public Employees(String name, int age) {
        this.id = counter++;
        this.name = name;
        this.age = age;
    }
  }