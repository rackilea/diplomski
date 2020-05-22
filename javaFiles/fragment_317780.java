public static void main(String[] args) {
    Object[] baseArray = new ArrayList<String>().toArray();
    System.out.println(baseArray.getClass().getCanonicalName());

    String[] improvArray = new ArrayList<String>().toArray(new String[5]);
    System.out.println(improvArray.getClass().getCanonicalName());
}