public static void main(String[] args) {
    ArrayList<Object> list = new ArrayList<>();
    for (int i = 0; i <200000 ; i++) {
        list.add(new Object());
    }
    System.gc();
    synchronized(list) {
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}