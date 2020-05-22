import java.util.Random;
public class RandomInterfaceImpl implements RandomInterface {
    private Random rnd;
    public RandomInterfaceImpl(){
        rnd = new Random();
    }
    @Override
    public void setFirstName(String value) {
        System.out.println("called setFirstName");

    }

    @Override
    public void setLastName(String value) {
        System.out.println("called setLastName");

    }

    @Override
    public void setGender(String value) {
        System.out.println("called setGender");

    }

    @Override
    public void getNextRandomMethod(String value) {
        int nextRand = rnd.nextInt(3);
        switch(nextRand){
        case 0: setFirstName(value); break;
        case 1: setLastName(value); break;
        case 2: setGender(value); break;
        }

    }

}

public static void main(String[] args) {
        RandomInterface myInterface = new RandomInterfaceImpl();
        myInterface.getNextRandomMethod("Foo");
        myInterface.getNextRandomMethod("Foo");
        myInterface.getNextRandomMethod("Foo");
    }