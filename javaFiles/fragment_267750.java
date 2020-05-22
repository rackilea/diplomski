public class ParticipantIndexComparator implements Comparator<Participant>
{
    public int compare(Participant p1, Participant p2)
    {
        Long time1 = p1.kpTime.get(kpSelected);
        Long time2 = p2.kpTime.get(kpSelected);
        return Long.valueOf(time1).compareTo(time2);
    }
}