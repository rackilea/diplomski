public class IckeMain {
    Scanner inread = new Scanner (System.in);
    int num;

    int [] array;
    int [] nyArr;


    public IckeMain(int num) {
        this.num = num;
    }

    public void fillArray () {
        array = new int [num];
        nyArr = new int [num];
        System.out.println("You chose: " + num + " with size: " +array.length);

        for (int j=0; j<num; j++) {
            array[j] = (int)(Math.random() * 99);
            System.out.println("Unsorted: " +array[j]);
        }
    }

    public int getNum() {
        return num;
    }

}