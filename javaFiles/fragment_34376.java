static public void sortArrayByDate(List<Artist> list) {       

    Collections.sort(list, new Comparator<Artist>() {
        @Override
        public int compare(Artist lhs, Artist rhs) {
            return lhs.getDate().compareTo(rhs.getDate());
        }
    });

}