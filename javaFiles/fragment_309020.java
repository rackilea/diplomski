private void Update(){

    ParseQuery<ParseObject> query = ParseQuery.getQuery("Table Name");
    query.getInBackground(parsekey, new GetCallback<ParseObject>() {
        public void done(ParseObject gameScore, ParseException e) {


            if (e == null) {

                if(camera!=null) {
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    camera.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte imageInByte[] = stream.toByteArray();
                    encodedImage = Base64.encodeToString(imageInByte, Base64.DEFAULT);
                    image = new ParseFile("image.txt", imageInByte);                  

                }else{
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.user_icon);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte imageInByte[] = stream.toByteArray();
                    encodedImage = Base64.encodeToString(imageInByte, Base64.DEFAULT);
                    image = new ParseFile("image.txt", imageInByte);
                }




              findViewById(R.id.editName)).getText().toString(),Profile.this);
            gameScore.put("name", ((EditText) findViewById(R.id.editName)).getText().toString().trim());
            gameScore.put("gender",gender_val);
            gameScore.put("country",country_val);
            gameScore.put("dateofbirth",((TextView) findViewById(R.id.editdate)).getText().toString().trim());
            gameScore.put("profession",profession);
            gameScore.put("image",image);

            gameScore.saveInBackground();


                Toast.makeText(Profile.this,"SuccessFull Updated",Toast.LENGTH_LONG).show();

            }else{
                Log.e("erroreeeee", DataBase.getUserObjectId(Profile.this)+"  "+e.getMessage());
            }

        }

    });
}