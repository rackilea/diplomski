public static ArrayList<Meteorit> meteorits = new ArrayList<Meteorit>();

Iterator<Meteorit> itr = meteorits.iterator();

while (itr.hasNext()) {
       if (itr.next()==this) {
          itr.remove();
       }
}