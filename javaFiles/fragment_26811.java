try {
        File file = new File("D:\\prectice\\JSONPrectice\\file.json");
        String s1 = FileUtils.readFileToString(file);
        JSONObject root = new JSONObject(s1);
        JSONArray sportsArray = root.getJSONArray("result");
        JSONObject arrayObject = sportsArray.getJSONObject(0);
        JSONObject landmark = arrayObject.getJSONObject("landmark");

        JSONObject mouth_upper_lip_left_contour2 = landmark.getJSONObject("mouth_upper_lip_left_contour2");

    } catch (Exception e) {
        e.printStackTrace();
    }