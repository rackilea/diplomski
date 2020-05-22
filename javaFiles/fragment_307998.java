class Events
implements Comparable
{
    Date eventDate;
    String eventType;

    int eventScore()
    {
        if (eventType.equals("Maths"))
            return 0;
        else if (eventType.equals("Science"))
            return 1;
        else if (eventType.equals("History"))
            return 2;
        else if (eventType.equals("Alegbra"))
            return 3;
        return 4;
    }

    public int compareTo(Object o)
    {
        Events other = (Events)o;
        if (other.eventDate.before(this.eventDate))
            return -1;
        else if (other.eventDate.after(this.eventDate))
            return 1;
        return other.eventScore() < this.eventScore() ? -1 : 1;
    }
}