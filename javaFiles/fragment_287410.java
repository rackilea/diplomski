while (!cJoin.isAfterLast()) {
     Position p = new Position();
     p.mLat = cJoin.getString(1);
     p.mLon = cJoin.getString(0);
     latLon[index++] = p;
 }