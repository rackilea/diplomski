public CartRequest(String total_amount, String user_id, String date, String time, JSONArray cartitems){
   super(Request.Method.POST, REQUEST_URL, null, null);
   params = new HashMap<>();
   params.put("total_amount", total_amount);
   params.put("user_id", user_id);
   params.put("date", date);
   params.put("time", time);
   params.put("cartitems", String.valueOf(cartitems));
}