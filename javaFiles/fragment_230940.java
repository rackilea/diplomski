public class Dog {
    String name;
}

public class HugeKennel {
    Double[] memmoryWaste = new Double[10000000];


    public List<Dog> getDogs() {
        SneakyDog trouble = new SneakyDog("trouble");
        return Arrays.asList(trouble);
    }

    class SneakyDog extends Dog {
        SneakyDog(String name) {
            this.name = name;
        }
    }

}