@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counter that = (Counter) o;
        return counter == that.counter;
    }