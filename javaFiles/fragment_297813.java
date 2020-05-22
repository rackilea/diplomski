public class LexComp<T extends Comparable<T>> implements Comparator<List<T>> {

    @Override
    public int compare (List<T> la, List<T> lb) {
        Iterator<T> ita = la.iterator();
        Iterator<T> itb = lb.iterator();
        while(ita.hasNext() && itb.hasNext()) {
            T ea = ita.next();
            T eb = itb.next();
            int cr = ea.compareTo(eb);
            if(cr != 0x00) {
                return cr;
            }
        }
        if(itb.hasNext()) {
            return 1;
        } else if(ita.hasNext()) {
            return -1;
        }
        return 0;
    }

}