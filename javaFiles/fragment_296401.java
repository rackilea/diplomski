public class Util {

    public static Object getValue(Pair<?, ?> _pair, String k) throws Exception {
        // check specific class and return / throw error
        // if (_pair instanceof GrandChildPair) {

        // OR check if it extends ChildPair and return / throw error
        if (_pair.getClass().isAssignableFrom(ChildPair.class) == false) {
            throw new Exception("call not allowed");
        }

        if (_pair.getK().equals(k) == false) {
            return null;
        }

        return _pair.getV(); 
    }
}