public class BoxClient {

    public static void main(String[] args) {
        Box<String> sBox = new Box<String>();
        Box<Integer> iBox = new Box<Integer>();

        iBox.put(1);
        sBox.put(iBox);

        System.out.println(sBox.get()); 
    } 

}