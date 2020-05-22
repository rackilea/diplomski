public class BetterArrayList<E> extends ArrayList<E> {

    private static final long serialVersionUID = 1L;

    public BetterArrayList(ArrayList<E> passArr) {
        this.addAll(passArr);
    }

    public E pop() {
        return this.remove(this.size() - 1);
    }
    public void print() {
        this.forEach(elem ->{
            System.out.println(elem);
        });
    }

    public static void main(String[] args) {
        // int[] ints = new int[] {1,2,3,4,5};
        Integer[] ints = new Integer[] {1,2,3,4,5};

        ArrayList<Integer> arrs = new ArrayList<>(Arrays.asList(ints));
        BetterArrayList<Integer> betterArr = new BetterArrayList<>(arrs);

        System.out.println("ArrayList: " + arrs);
        System.out.println("BetterArrayList: " + betterArr);

        betterArr.pop();
        System.out.println("BetterArrayList After Pop: " + betterArr);
    }

}