final Set tailleDetails = new TreeSet(new TailleDetailComparator());
                tailleDetails.add(...);

        public class TailleDetailComparator implements Comparator {

                @Override
                public int compare(final TailleDetail o1, final TailleDetail o2) {
                    return o1.mesure.compareTo(o2.mesure);
                }
            }