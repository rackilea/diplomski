response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");
response.getWriter().write(
    new JSONObject()
        .put("codeList", new JSONArray(rmsCodeList))
        .put("nameList", new JSONArray(rmsNameList)).toString()
);