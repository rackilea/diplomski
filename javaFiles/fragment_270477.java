public class Cards extends Program {

    private int[] x;
    private int[] k;
    private int length; 
    private String type;

    public Cards(int l, String name) {
        length = l;
        x = new int[length] ;
        k = new int[length] ;
        type = name;
    }
}