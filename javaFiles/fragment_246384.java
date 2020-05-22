String newString = price.getText().toString();

ParseObject dealinfo = new ParseObject("Deals");
dealinfo.put("Brand", "Budweiser");
dealinfo.put("Size", "6");
dealinfo.put("Price", newString);
dealinfo.saveInBackground();