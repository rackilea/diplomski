do {
        wps = new Wp();
        wps.id = cur.getDouble(0);
        wps.type = cur.getDouble(0);
        wps.shortname = cur.getString(1);
        wps.name = cur.getString(2);

        waypoints.add(i, wps);
    } while(cur.moveToNext());