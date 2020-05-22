public ChatRecyclerViewAdapter(Context mContext, ArrayList<String> mMessage, ArrayList<String> mAuthor, String mRoomID, DatabaseReference reference) {

  // this.mMessage = mMessage;  // comment or remove this line
  // this.mAuthor = mAuthor;   // comment or remove this line
   this.mContext = mContext;
   this.mRoomID = mRoomID;

   messageList = new ArrayList<>();  // initialize messageList object

   mDatabaseReference = reference.child(mRoomID+"_messages");
   mDatabaseReference.addChildEventListener(mListener);

}