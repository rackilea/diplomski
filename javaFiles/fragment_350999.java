JSONObject jsonObj = new JSONObject();
        JSONObject obj  = jsonObj.fromObject(userReorderOption);
        JSONArray columnName = (JSONArray) obj.get("COLUMN");

        for (int i = 0; i < columnName.size(); i++) {
            System.out.println(columnName.getString(i));

        }