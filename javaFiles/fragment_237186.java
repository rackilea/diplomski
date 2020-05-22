public class Test {

    public static void main(String[] args) {

        ArrayList al = new ArrayList();
        al.add(new StringBuffer("keshav"));
        al.add(new StringBuffer("sharma"));

        Iterator itr = al.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }

}