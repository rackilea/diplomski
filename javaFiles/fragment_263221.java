import java.util.Arrays;

class MainClass {

    private int[] ints;

    public void createArray(){
        this.ints = new int[10];
    }

    public int[] getInts() {
        return ints;
    }
}
class Test{
    public static void main(String[] args) {
        MainClass mcl = new MainClass();
        mcl.createArray();
        for (int i = 0;i<10;i++){
            //cannot resolve symbol ints - why?
            Arrays.fill(mcl.getInts(),0,9,8);
        }
    }
}