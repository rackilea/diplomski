imageAnim.setScaleType(ScaleType.FIT_XY);           

        JSONObject jsonObject = new JSONObject();
        String result = "";
        String json = "";
        String json_base64 = "";

        WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int lim= display.getWidth()/80;


    //make Json and decode to base64
        try {
            Time today = new Time("UTC");
            today.setToNow();
            jsonObject.put("language", "fa");
            jsonObject.put("start", 0);
            jsonObject.put("limit", lim);
            JSONObject filter = new JSONObject();
            JSONObject flags = new JSONObject();
            //flags.put("my_app", "no");
            //flags.put("favorite", "all");
            //filter.put("flags", flags);
            filter.put("my_apps", false);
            JSONArray JA=new JSONArray();
            JA.put(1);
            filter.put("any_os",JA);
            jsonObject.put("time_stamp", today.format("%Y-%m-%dT%H:%M:%SZ"));
            json = jsonObject.toString();
            byte[] json_bytes = json.getBytes("UTF-8");
            json_base64 = Base64.encodeToString(json_bytes, Base64.DEFAULT);

        } catch (Exception e) {

        }

        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("request", json_base64));
        InputStream is = null;