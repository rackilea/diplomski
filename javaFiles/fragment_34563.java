class MessageViewHolderOfFriend extends RecyclerView.ViewHolder {

    private final Context context;

    public  MessageViewHolderOfFriend(View v) {
        super(v);
        context = v.getContext();

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,NewActivityToRun.class);
                context.startActivity(intent);
            }
        });

    }