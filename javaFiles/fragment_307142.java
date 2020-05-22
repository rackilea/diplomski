public class BiggestFinder {
    public void showBiggester(Object o) throws Exception {
        TreeMap<Integer, String> data = new TreeMap<Integer, String)();
        for (Field f  : o.getDeclaredFields()) {
            Object v = f.getValue(o);
            if (v instanceof Integer) {
                if (data.get(v)!=null) {
                    System.out.println("Value for "+f.getName()+" is the same as "+data.get(v));
                }
                else {
                    data.put((Integer)f.getValue(o), f.getName());
                }
            }
        }

        System.out.println("Largest is "+data.lastEntry().getValue());
    }
}