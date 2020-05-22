private static final float[] ZEROES = { 0.0f, 0.0f, 0.0f };
private static final float[] POINT_FIVES = { 0.5f, 0.5f, 0.5f };
private static final float[] ONE_FIVES = { 1.5f, 1.5f, 1.5f };
private static final float[] ONES = { 1.0f, 1.0f, 1.0f };

public static void main(String[] args) {
    RTree<Object> rt = new RTree<Object>(50, 2, 3);
    rt.insert(ZEROES, ONES, "Region1");
    rt.insert(ONES, ONES, "Region2");

    System.out.println(rt.search(POINT_FIVES, ZEROES));

}