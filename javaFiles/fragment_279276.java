Map<String,String> params = new LinkedHashMap<>();
params.put("phone", "phone");

StringBuilder postPraamString = new StringBuilder();
for (Map.Entry<String,Object> param : params.entrySet()) {
     if (postPraamString.length() != 0) postPraamString.append('&');
         postPraamString.append(URLEncoder.encode(param.getKey(), "UTF-8"));
         postPraamString.append('=');
         postPraamString.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
     }
byte[] postDataBytes = postData.toString().getBytes("UTF-8");
writer.write(postDataBytes);