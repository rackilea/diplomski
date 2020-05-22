public ForkJoinTask<?> seq(final ForkJoinTask<?> a, final ForkJoinTask<?> b) {
    return adapt(new Runnable() {
        public void run() {
            a.invoke();
            b.invoke();
        }
    });
}