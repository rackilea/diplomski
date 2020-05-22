public class ClassTest<T extends Interface1 & Interface2> {
    private ArrayList<Class<T>> testClass = new ArrayList<Class<T>>();    
}

interface Interface1 {}
interface Interface2 {}