for (Object arg : args) {
    if (arg instanceof Integer) {
        this.id = (Integer)arg;
    } else if (arg instanceof String) {
        this.name = (String)arg;
    } else if (arg instanceof Date) {
        this.isFoo = (Date)arg;
    }
}