private static <T extends Comparable<T>> void selectionSort(final ArrayList<T> anytypeArrayList) {

            for (int i = 0; i < anytypeArrayList.size() - 1; i++) {
                int ilow = i;

                for (int j = i + 1; j < anytypeArrayList.size(); j++) {
                    if (anytypeArrayList.get(ilow).compareTo(anytypeArrayList.get(j)) > 0) {
                        ilow = j;
                    }
                }
                final T itemp = anytypeArrayList.get(ilow);
                anytypeArrayList.set(ilow, anytypeArrayList.get(i));
                anytypeArrayList.set(i, itemp);

            }
        }