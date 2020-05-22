for (Date d: produkt.keySet()){
        System.out.println( d + " pocet:" + produkt.get(d));
        if (d.before(now)) {
            obsah.get(name).remove(d);
        }
    }