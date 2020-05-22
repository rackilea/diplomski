JSONObject json=new JSONObject();
json.put("contactName", contactDetails.getcontactName());
json.put("phoneNumber", contactDetails.getphoneNumber());

...
postparams.put("contact", json.toString());