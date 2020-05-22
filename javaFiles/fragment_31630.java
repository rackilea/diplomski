for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                yourshifts[i] = obj.getString("date");
            if (yourshifts[i].contains(date)) {
                isfound = true;
                break;

            }
        }