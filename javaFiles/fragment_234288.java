public class Low20 {
    private List<Integer> list = new ArrayList<Integer>();

    public static final void main(String[] args) {
        new Low20();
    }

    public Low20() {
        Random random = new Random();
        for (int x=0;x<100000;x++) {
            add(random.nextInt(100000));
        }
        System.out.println(list);
    }

    public void add(int value) {
        if (list.size() < 20) {
            list.add(value);
        } else {
            for (int x=0;x<list.size();x++) {
                if (list.get(x) > value) {
                    list.remove(x);
                    list.add(value);
                    return;
                }
            }
        }
    }
}