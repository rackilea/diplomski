Collections.sort(coda, new Comparator<ObjType>() {
    public int compare(ObjType a, ObjType b) {
        boolean b1=a.isManual();
        boolean b2=b.isManual();

        if(b1 && b2) return 0;
        if (b1) return -1;
        if (b2) return 1;

        Double affinity1 = a.getAffinity();
        Double affinity2 = b.getAffinity();
        return affinity1.compareTo(affinity2);
    }
});