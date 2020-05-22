import java.util.*;

interface A {};

class B {};

class Test {

    public <T extends B & A> List<T> asList(Collection<T> elements) {
        List<T> result = new ArrayList<>(elements.size());
        for (T element : elements) result.add(element);
        return result;
    }
}