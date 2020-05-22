ref.addListenerForSingleValueEvent(new ValueEventListener() {

    public void onDataChange(DataSnapshot snapshot) {
        Iterable<DataSnapshot> ds = snapshot.getChildren();

        //getting maximum number of children
        long allNum = snapshot.getChildrenCount();
        int maxNum = (int)allNum;

        //getting the random integer from number of children
        int randomNum = new Random().nextInt(maxNum);

        Iterator<DataSnapshot> ids = ds.iterator();

        int count = 0;

        //has next will check if there are values in the next iteration , while count is used as a position substitute.
        while(ids.hasNext() && count < randomNum) {
            ids.next();
            count ++; // used as positioning.
        }           

        Map<String, Object> newPost = (Map<String, Object>) ids.next().getValue(); // ids will take the value in the iterator (iterate at key) 
        //getting the message from the key
        msgID = newPost.get("id").toString();
    }`