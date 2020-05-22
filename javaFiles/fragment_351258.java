if (a != null) {
    try {
        return a.clone();
    } catch (CloneNotSupportedException e) {
        e.printStackTrace();
    }
}
throw new TotallyFooException();