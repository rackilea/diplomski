class Example<T extends Number> extends Number {
//                              ^^^^^^^^^^^^^^
    ...
    @Override
    public int intValue() {
        return num.intValue();
    }
    // and so on
}