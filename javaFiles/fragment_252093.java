int total = 100;
int i = 0;

// You should use a more specifc type than Object if you can
Map<Integer, Object> m = new HashMap<Integer, Object>();

while (i < total) {

    Object o = //what you want to put into the HashMap on each iteration

    m.put(i, o);

    Thread.sleep(1000);
    i++;
}