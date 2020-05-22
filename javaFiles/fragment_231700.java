Collections.sort(poll, new Comparator<PolledData>() {
        @Override
        public int compare(final PolledData object1, final PolledData object2) {
            return object1.getName().compareTo(object2.getName());
        }
       } );