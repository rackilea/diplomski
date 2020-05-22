public class Sequences {

    public static ArrayList<String> sequences(String s) {
        ArrayList<String> list = new ArrayList<String>();
        if (s.length() == 0) {
            list.add("");
            return list;
        }
        String firstChar = s.substring(0, 1);
        String theRest = s.substring(1, s.length());
        ArrayList<String> siffixSequence = sequences(theRest);
        list.addAll(siffixSequence);
        for (String string : siffixSequence) {
            list.add(firstChar + string);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Sequences.sequences("brat"));
        // prints [, t, a, at, r, rt, ra, rat, b, bt, ba, bat, br, brt, bra, brat]
    }

}