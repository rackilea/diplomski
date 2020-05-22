JSONObject totalData=new JSONObject(results.toString());
        JSONObject brandResults=totalData.getJSONObject("result");
        Log.e("Result output", brandResults.toString());

        int brandCounts = totalData.getInt("count");

        Log.e("BRAND COUNTS", ""+brandCounts);
        if (brandCounts > 0) {

            for (int i = 1; i <= brandCounts; i++) {
                JSONObject items = brandResults
                        .getJSONObject(Integer.toString(i));
                String brand_id=items.getString("brand_id");
                Log.e("Brand id", brand_id);

            }
        }