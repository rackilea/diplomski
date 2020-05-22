private ArrayList<Integer> dataArray;

public void getData() {
    ParseQuery<ParseObject> query = ParseQuery.getQuery("ParseClass");
    query.getInBackground("lxFzCTeOcl", new GetCallback<ParseObject>() {
        public void done(ParseObject parseObject, ParseException e) {    
            if (e == null) {
                String object = parseObject.getString("value");
                Integer objectValue = Integer.parseInt(obiect);
                if(dataArray==null)
                    dataArray = new ArrayList<Integer>();
                dataArray.add(objectValue);
            } else {
                Log.d("score", "Error: " + e.getMessage());
            }
        }
    });
}