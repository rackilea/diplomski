final List<String> list = Collections.synchronizedList(new ArrayList<String>());
for (int i = 0; i < 100; i++) {
    list.add("Number" + i);
}

new Thread() {
    public void run() {
        synchronized (list) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}.start();

new Thread() {
    public void run() {
        synchronized (list) {
            list.remove("Number5");
        }
    }
}.start();