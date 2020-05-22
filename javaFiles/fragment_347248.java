List<TabellLinje> tabellListe = new ArrayList(tabell.values());
    Collections.sort(tabellListe, new Comparator<TabellLinje>() {
        @Override
        public int compare(TabellLinje o1, TabellLinje o2) {
            return o1.Poeng - o2.Poeng;
        }
    });