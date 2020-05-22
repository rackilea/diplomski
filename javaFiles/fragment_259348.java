private void parseResponse(String responseString) {
        try {
            //{num : 1, vol: 22}
            Object object = new JSONTokener(responseString).nextValue();
            if (object instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) object;
                String num = jsonObject.optString("num");
                String vol = jsonObject.optString("vol");

                textView.setText("num="+num+" "+"vol="+vol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }