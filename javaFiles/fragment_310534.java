ref=FirebaseDatabase.getInstance().getReference().child("timeAdded");
// you can set TimeStamp to this reference like this

String timeAddedLong=ServerValue.TIMESTAMP.toString;

ref.setValue(timeAddedLong);


// get previous time added

ValueEventListner listner=ValueEventListner() {

public onDataChanged(DataSnap snap) {
    if(snap.value!=null) {
     long timeadded=parseToLong(snap.value.tostring)

     }
  ref.removeValueEventListner(this)
 }
}
ref.addValueEventListner(listner);