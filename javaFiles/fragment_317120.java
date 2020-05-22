public ArrayList<Record> foo(){
    static ArrayList<Record> records = new ArrayList<Record>();

    try{
       SomeoneElsesLibrary.loadData( ... );
    } catch (BazException be){ // you just handle the exception here
    }

    return records;
}