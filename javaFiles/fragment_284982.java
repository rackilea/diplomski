public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5 };
    Object[] obj1 = { "Nguyen Viet Quan", 28, "Doan Thi Ha", array };
    Object[] obj2 = { "Nguyen Viet Quan1", 28, "Doan Thi Ha1" };
    System.out.println(Arrays.deepToString(join(obj1, obj2)));
}