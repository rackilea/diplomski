public static void main(String[] args) throws IOException {

    Array m = new Array();

    int[] startArray = {1,2,3,4,5};
    m.setGroup(startArray);

    int[] endArray = {6,7,8,9,10,11,12};
    m.addNums(endArray);

    System.out.println(Arrays.toString(m.getGroup()));
}