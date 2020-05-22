interface DataSource {
    boolean respondsTo(String identifier)
}

class DataSource1 implements DataSource {
    DataSource1(InputStream is) { /* magic goes here */ }
    @Override boolean respondsTo(String identifier) { identifier in ["DS1 idX", "DS1 idY", "DS1 idZ"] }
}

class DataSource2 implements DataSource {
    DataSource2(InputStream is) { /* magic goes here */ }
    @Override boolean respondsTo(String identifier) { identifier in ["DS2 idX", "DS2 idY", "DS2 idZ"] }
}

// ...

class DataSource20 implements DataSource {
    DataSource20(InputStream is) { /* magic goes here */ }
    @Override boolean respondsTo(String identifier) { identifier in ["DS20 idX", "DS20 idY", "DS20 idZ"] }
}