for (int i = 0; i < ids.length; i++) {
  String identifier = "contact" + String.format("%02s", i+1) + "Button";

  // next line taken from louiscoquio's answers. Credits go to him!
  int id = getResources().getIdentifier(identifier, "drawable", theContext.getPackageName());

  views.setImageViewBitmap(id, data.get(i).getFriendImage());
}