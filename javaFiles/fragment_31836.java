public static void main(String[] args) {
    LerSalas();
    Collections.sort(salaData, new Comparator<Sala>() {
        @Override
        public int compare(Sala o1, Sala o2) {
            return o1.getSalas().compareTo(o2.getSalas());
        }
    });
    salaData.stream().forEach(System.out::println);
}