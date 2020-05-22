class CloseHandler implements Runnable {
    List<Runnable> children = new ArrayList<>();

    void add(Runnable ch) { children.add(ch); }

    @Override
    public void run() { children.forEach(Runnable::run); }
}