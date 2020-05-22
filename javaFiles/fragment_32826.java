public List<MyData> getMyData(MyParams params) throws Exception {
    List<Callable<MyData>> tasks = new ArrayList<>();
    for (Person p : persons) {
        tasks.add(new Callable<MyData>() { // use Lambda in Java 8
            public MyData call() {
                MyData d = new MyData();
                d.setPerson(p);
                d.setTypeA(getTypeAFromDatabase1(p));
                d.setTypeB(getTypeBFromDatabase2(p));
                d.setTypeC(getTypeCFromSomeWebService(p));
                return d;
            }
        });
    }
    List<MyData> result = new ArrayList<>();
    for (Future<MyData> future : executor.invokeAll(tasks, 3000, TimeUnit.MILLISECONDS)) {
        result.add(future.get());
    }
    return result;
}