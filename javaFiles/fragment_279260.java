package so_6949760;

import java.util.HashMap;

public class SweetCompilingGenerics {

    @SuppressWarnings("serial")
    public static class Sweet<X> extends HashMap<X, Sweet<X>> {}

    public static void main(String[] args) {
        Sweet<String> sweetStr = new Sweet<String>();
        Sweet<Sweet<Integer>> whatever = new Sweet<SweetCompilingGenerics.Sweet<Integer>>();

        assert sweetStr.getClass().equals(whatever.getClass()) : "who made generics a runtime mechanism?";
        assert sweetStr.getClass() == whatever.getClass() : "who made generics a runtime mechanism?";

        System.out.format("Is %s a Sweet<String> ?\n", sweetStr.getClass().getCanonicalName());
        System.out.format("Is %s a Sweet<Sweet<Integer>> ?\n", whatever.getClass().getCanonicalName());
    }
}