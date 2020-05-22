try {

  if (cursor.moveToFirst()) {
    do {
      JSONObject data = new JSONObject();
      data.put("id", cursor.getInt(1));
      data.put("qty", cursor.getInt(2));
      data.put("amount", cursor.getInt(7));
      data.put("tax_id","0");
      data.put("sub_total", cursor.getInt(6));
      myara.put(data);
    } while (cursor.moveToNext());

    modelList.put("product_detail",myara);
  }
}
catch (JSONException e)
{
}