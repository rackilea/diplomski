while(r.next()) {
        Vector v = new Vector(d);
        v.add(r.getInt(1));
        v.add(r.getInt(2));
        ...
        v.add(r.getString(12));

        rr.add(v);
    }