public MyModel setPlace(JSONObject thisObject) throws JSONException {

MyModel thisMyModel = new MyModel();
author_name = thisObject.getString("author_name");
text = thisObject.getString("text");

thisMyModel.setAuthor_name(author_name);
thisMyModel.setText(text);

return thisMyModel;

}