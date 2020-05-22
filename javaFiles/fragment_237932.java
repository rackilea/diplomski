public class DataView {
    private static ArrayList<Float> rectData = new ArrayList<Float>();
    private static ArrayList<Float> textData = new ArrayList<Float>();

    DataView(){
        iter(x -> functionA(5, 10));
        iter(x -> functionB(10, 12));
    }
    private void iter(Consumer<Float> function){
        textData.forEach(function);
    }
    private void functionA(int a, int b){
        //dostuff
    }
    private void functionB(int a, int b){
        //do other stuff
    }
}