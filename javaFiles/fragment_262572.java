ArrayList<MessageDetails>  arrMessageDetails=new ArrayList<MessageDetails>;
if (c.moveToLast()) {
 do {
       if (c.getString(c.getColumnIndexOrThrow("address")) == null) {
            c.moveToNext();
            continue;
        }

 String Body = c.getString(c.getColumnIndexOrThrow("body"))
                            .toString();
 CharSequence text = c.getString(c.getColumnIndexOrThrow("type")).toString();
 MessageDetails object=new MessageDetails();
 object.setmesgType(text);
 object.setmesgBody(Body);
 arrMessageDetails.add(object);
} while (c.moveToPrevious());