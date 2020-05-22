public class DataTypes {
    public static void main(String[] args) {
        Gen<?> array[] = new Gen<?>[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Gen<Integer>(i);
        }
        for (int i  = 0; i < array.length; i++) {
            System.out.print(array[i].getData() + " ");
        }
    }
}