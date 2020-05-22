while (curTAB.moveToNext()) {
    String s_latitude = curTAB.getString(1);
    String s_longitude = curTAB.getString(2);
    String s_speed = curTAB.getString(5);
    count++;
    int position = curTAB.getPosition();

    if(curTAB.moveToNext()) {
        String next_speed = curTAB.getString(5);
        curTAB.moveToPosition(position);
    }
}