StringBuilder sb = new StringBuilder();
        while ((s = request.getReader().readLine()) != null) {
            sb.append(s);
        }
       JSONObject jSONObject = new JSONObject(sb.toString());

        System.out.println(jSONObject.getString("commandid"));