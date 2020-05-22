JSONObject jsonObj = new JSONObject(line);
SONArray asks = jsonObj.getJSONArray("asks").getJSONArray(0);

Double price = Double.valueOf(asks.getString(0));
Double qty = Double.valueOf(asks.getDouble(1));

System.out.printf("Ask price: %.6f, quantity %.4f", price, qty);