public ArrayList<Record> foo(){
    static ArrayList<Record> records = new ArrayList<Record>();

    // if SomeoneElsesLibrary.loadData raise the BazException
    // it is propagated to the caller of foo()
    SomeoneElsesLibrary.loadData( ... );

    return records;
}