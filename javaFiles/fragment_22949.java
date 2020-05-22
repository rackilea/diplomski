class WDate implements Comparable<WDate>
{
    Date date;
    Date getDate() { return date;}

    public WDate(Date date) {
        this.date = date;
    }
    @Override
    public int compareTo(WDate other) {
        return date.compareTo(other.date);
    }
}