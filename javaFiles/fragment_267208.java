class NoteData implements Comparable {
    public String title;
    public String text;
    public long timeInMs;
    //etc

    @Override
    public int compareTo(NoteData other) {
        return title.compareTo(other.title);
    }

}