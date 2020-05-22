try {
   json_url = "http://example.com/get_item_data.php?uid=\""+ 
                  URLEncoder.encode( inv_no, "UTF-8") + "\"";
} catch (UnsupportedEncodingException e) {
   e.printStackTrace();
}