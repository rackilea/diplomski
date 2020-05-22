public static void main(String[] args) {
    String txt = "0, 2, 23131312,\"This, is a message\", 1212312";

    System.out.println(Arrays.toString(txt.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));

}