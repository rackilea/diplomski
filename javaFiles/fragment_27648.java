private class UpdateAnswer extends AsyncTask<Void, Void, ArrayList<Object>> {
    int submitId;
    String submitQuestion;
    friendsViewHolder holder;

    public UpdateAnswer (int submitId, String submitQuestion, friendsViewHolder holder) {
        this.submitId = submitId;
        this.submitQuestion = submitQuestion;
        this.holder = holder;
    }