KlantComparator kc = new KlantComparator();
    ArrayList klants = new ArrayList<Klant>();
    Klant o = new Klant();
    klants.add(o);
    klants.add(new Klant());
    klants.add(new Klant());
    Collections.sort(klants, kc);
    Collections.binarySearch(klants, o, kc);