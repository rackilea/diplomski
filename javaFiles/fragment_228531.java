if (cr.getInt(cr.getColumnIndex("type")) == 2) {
    if(id != cr.getInt(cr.getColumnIndex(cr.getColumnName(0)))) {
        id = cr.getInt(cr.getColumnIndex(cr.getColumnName(0)));

        String address = cr.getString(cr.getColumnIndex("address"));
        Database.messageSent(SmsOutgoingObserver.this, address);
            Log.d("OUTGOING", address);
        } else {
            Log.d("OUTGOING", "MESSAGE ALREADY LOGGED");
        }
     };
}