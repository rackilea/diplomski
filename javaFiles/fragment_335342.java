public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.ViewHolder> {

    // private ArrayList<String> mMessage = new ArrayList<>();  // comment or remove this line
    // private ArrayList<String> mAuthor = new ArrayList<>();  // comment or remove this line
    private String mRoomID;
    private Context mContext;
    private DatabaseReference mDatabaseReference;
    // private ArrayList<DataSnapshot> mSnapshotList; // comment or remove this line

    private ArrayList<Message> messageList;  // add this member 

}