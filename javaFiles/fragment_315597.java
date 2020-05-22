public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
  if(dataSnapshot.exists()
     {
        if (dataSnapshot.getChildrenCount()!=0){
            if(dataSnapshot.hasChild("Housenumber")
           {
            house = dataSnapshot.child("Housenumber").getValue().toString();
            }
            if(dataSnapshot.hasChild("Address")
            {
            address = dataSnapshot.child("Address").getValue().toString();
            }
            if(dataSnapshot.hasChild("Postcode")
            {
            postcode = dataSnapshot.child("Postcode").getValue().toString();
            }
            if(dataSnapshot.hasChild("Phone")
            {
            phone = dataSnapshot.child("Phone").getValue().toString();
            }
            if(dataSnapshot.hasChild("Date")
            {
            date = dataSnapshot.child("Date").getValue().toString();
            }
     } }