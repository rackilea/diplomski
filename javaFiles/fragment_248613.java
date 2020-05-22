public interface MethodRunner {
    public void run(Object arg);
}

List<MethodRunner> a = new ArrayList<>();
a.add(new MethodRunner() {
    @Override
    public void run(Object arg) {
        myCustomMethod1(arg);
    }
});
a.add(new MethodRunner() {
    @Override
    public void run(Object arg) {
        myCustomMethod2(arg);
    }
});

Object o = new Object();

for (MethodRunner mr : a) {
    mr.run(o);
}