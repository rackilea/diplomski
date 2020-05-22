public static void main(String[] args) {
    new Thread() { run() { 
        ArrayListClass.main(null);
    }}.start();

    new Thread() { run() { 
        TestingArrayList.main(null);
    }}.start();
}