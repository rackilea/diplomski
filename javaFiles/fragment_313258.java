@Override
public void onDataChange(DataSnapshot dataSnapshot) {
         if (dataSnapshot.exists()) {
               User user = dataSnapshot.getValue(User.class);
         }
}