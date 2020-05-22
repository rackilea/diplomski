public static final Comparator<movieCatalog> movieComparator = new Comparator<movieCatalog>() {
        public int compare(movieCatalog a1, movieCatalog a2) {
            return a1.name.compareTo(a2.name);
        }
    };


Collections.sort(movieCatakig,movieComparator);