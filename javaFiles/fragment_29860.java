fun checkDataNew() {
    var rootRef=FirebaseDatabase.getInstance().getReference("BG Data")
    // Read from the database
    rootRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            var isKeyFound = false; // local variables
            var foundKey;
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            for(data:DataSnapshot in dataSnapshot.children)
            {
                var oldEvent=data.child("recentEvent").getValue().toString()
                var oldDate:String=data.child("calendarTime").getValue().toString()
                var oldEmailID:String=data.child("emailID").getValue().toString()

                if(oldEvent.equals(recentEvent) && oldDate.equals(calendarTime) && oldEmailID.equals(emailID)) {
                    foundKey = data.key.toString()
                    isKeyFound = true
                }
            }

            // TODO: process the result here
            if (isKeyFound) {
              ...
            } else {
              ...
            }
        }

        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
        }
    })
}