public class GetUsersTask extends AsyncTask<Void, Void, List<User>> {

    private AsyncUserResponse delegate;
    public GetUsersTask(AsyncUserResponse delegate) {
        this.delegate = delegate;
    }    

    public List<User> doInBackground(Void... params) {
        List<User> users = new ArraryList<User>();
        // TODO: HTTP Request

        // TODO: Parse JSON string - store into list
        // Loop over some JSON array 
            String name = json.get("name");
            String image = json.get("image_url");
            User u = new User(name, image);
            users.add(u);
        // End loop 
        return users;
    }

    public void onPostExecute(List<User> result) {
        if (delegate != null) {
            delegate.onUsersReceived(result);
        } 
        // nothing else goes here - this method is done 
    }
}