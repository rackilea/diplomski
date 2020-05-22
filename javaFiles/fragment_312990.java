if (min_price.equalsIgnoreCase("null")) {
                Log.i("min", "msg");
                double maxprice = Double.parseDouble(max_price);
                compareMax(share_name, maxprice, action);
            } else if (max_price.equalsIgnoreCase("null")) {
                Log.i("max", "msg");
                double minprice = Double.parseDouble(min_price);
                compareMin(share_name, minprice, action);
            }