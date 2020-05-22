class Entry implements Comparable<Entry>{
    private String surname;
    private String initial;
    private String number;

    Entry(String surname, String initial, String number){
        this.surname = surname;
        this.number =number;
        this.initial = initial;
    }
    @Override
    public int compareTo(Entry entry){
        return this.surname.compareTo(entry.surname);
    }
}