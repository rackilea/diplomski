class BasicInterval<T extends Number, S extends Number2<T>> {
    public BasicInterval(S num, T start, T stop) {
        this.num = num;
        this.start_ = start;
        this.stop_ = stop;
    }

    public boolean isRev() {
        return num.compareTo(start_, stop_) < 1;
    }

    public T width() {
        return num.subtract(start_, stop_);
    }

    public S num;
    public T start_;
    public T stop_;
}