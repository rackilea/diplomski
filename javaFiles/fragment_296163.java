do {
        myCoord = new Coord(); //**********
        myCoord.userId = cur.getInt(0);
        myCoord.timestamp = cur.getLong(1);
        myCoord.x = cur.getDouble(2);
        myCoord.y = cur.getDouble(3);
        myCoord.coordType = cur.getInt(4);
        myCoord.id = cur.getInt(5);
        myCoord.coordTypeDesc = cur.getString(6);
        markerArray.add(myCoord);
        Log.d("getCoordMarkers()", "X: " + myCoord.x + " Y: " + myCoord.y);
        myCoord = null; //for the garbage collector *******
    } while( cur.moveToNext());