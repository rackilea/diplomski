private void changeAttTable() {

    Log.d("abcd","changeAttTable() reached");

     rootRefAttTable.addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(DataSnapshot dataSnapshot) {
             for(DataSnapshot yearsnap:dataSnapshot.getChildren()){
                for(DataSnapshot monthsnap:yearsnap.getChildren()){
                    for(DataSnapshot datesnap:monthsnap.getChildren()){
                        dateAtt = datesnap.child("date").getValue(String.class);
                        Log.d("abcd","date is: "+dateAtt);
                        entrydateAtt = datesnap.child("entryDate").getValue(String.class);
                        Log.d("abcd","enteryDate is: "+entrydateAtt);
                        intimeAtt = datesnap.child("inTime").getValue(String.class);
                        Log.d("abcd","inTime is: "+intimeAtt);
                        monthAtt = datesnap.child("month").getValue(String.class);
                        Log.d("abcd","month is: "+monthAtt);
                        myidAtt = datesnap.child("myID").getValue(String.class);
                        Log.d("abcd","myID is: "+myidAtt);
                        outtimeAtt = datesnap.child("outTime").getValue(String.class);
                        Log.d("abcd","outTime is: "+outtimeAtt);
                        statusAtt = datesnap.child("status").getValue(String.class);
                        Log.d("abcd","status is: "+statusAtt);
                        yearAtt = datesnap.child("year").getValue(String.class);
                        Log.d("abcd","year is: "+yearAtt);

                        getValuesAtt();
                        newRefAttTable.child(enterednewmpin).child(yearsnap.getKey()).child(monthsnap.getKey()).child(datesnap.getKey()).setValue(attRec);
                    }
                }

             }
         newRefAttTable.child(carriedmPIN).removeValue();
         }

         @Override
         public void onCancelled(DatabaseError databaseError) {

         }

     });

}

private void getValuesAtt(){
    Log.d("abcd","getValuesAtt() reached");

    attRec.setYear(yearAtt);
    attRec.setMonth(monthAtt);
    attRec.setMyID(myidAtt);
    attRec.setEntryDate(entrydateAtt);
    attRec.setStatus(statusAtt);
    attRec.setOutTime(outtimeAtt);
    attRec.setInTime(intimeAtt);
    attRec.setDate(dateAtt);
}