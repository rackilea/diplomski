while (managedCursor.moveToNext()) {
        String callDate = managedCursor.getString(date);
        Date callDayTime = new Date(Long.valueOf(callDate));
        if (<compare callDayTime with a "Date" of one week ago> ){
            String phNumber = managedCursor.getString(number);
            if (<phNumber is equal to the desired Phone>) {
                if(Integer.parseInt(callType) == CallLog.Calls.OUTGOING_TYPE){
                    // User called the phone number last week
                }
            }
        }       
}