ColorData data;
for (int i = 0; i < jsonObject.size(); i++) {
        data = new ColorData();

        //{"HSV":1120,"denominator":1,"numerator":1,"quantity":0.39}
        data.setHSV(((JSONObject)jsonObject.get(i)).getInt("HSV"));
        data.setDenominator(((JSONObject)jsonObject.get(i)).getInt("denominator"));
        data.setNumerator(((JSONObject)jsonObject.get(i)).getInt("numerator"));
        data.setQuantity(((JSONObject)jsonObject.get(i)).getDouble("quantity"));

        resList.add(data);
    }