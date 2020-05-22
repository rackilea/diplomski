public class Main {

    public static void main(String[] args) {
        try {
            // works
            Pair<String, Integer> pair = new Pair<>("someone", 35);
            Integer age = (Integer) Util.getValue(pair, "someone");
            System.out.println(age);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        try {
            // mismatch in K so returns null
            ChildPair<String, Integer> childPair = new ChildPair<>("ch", 20);
            Integer childAge = (Integer) Util.getValue(childPair, "sss");
            System.out.println(childAge);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        try {
            // error
            GrandChildPair<String, Integer> grandChildPair = new GrandChildPair<>("gh", 40);
            Integer grandChildAge = (Integer) Util.getValue(grandChildPair, "gh");
            System.out.println(grandChildAge);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        try {
            // error
            OtherChildPair<String, Integer> otherChildPair = new OtherChildPair<>("oh", 60);
            Integer otherChildAge = (Integer) Util.getValue(otherChildPair, "oh");
            System.out.println(otherChildAge);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}