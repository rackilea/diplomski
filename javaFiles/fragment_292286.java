public class IndexCount {
    private String Streaming;
    public IndexCount(String Streaming){
    this.Streaming = Streaming;
}

public void databaseIndexCounter( ){

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbref = db.getReference().child("Apps").child("IndexCount");
    dbref.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            Integer Stream = dataSnapshot.child("Streaming").getValue(Integer.class);
            Streaming = Stream.toString();
            Log.i("streamcount: ",Streaming);
            // call it here 
            nextStep();
        }
    }
}
public void nextStep(){
Log.i("stream count: ",streamcounter);
tvstreaming.setText(streamcounter);
}