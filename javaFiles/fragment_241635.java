public void channelRead(ChannelHandlerContext ctx, Object msg) /* throws Exception */
    TextWebSocketFrame frame = (TextWebSocketFrame) msg;
    try {

        String json = frame.text(); 
        JSONObject jsonObject = new JSONObject(json);
        int type = jsonObject.getInt("type");
        JSONArray msgJsonArray = jsonObject.getJSONArray("msg");
        String user = msgJsonArray.getString(0);
        String pass = msgJsonArray.getString(1);
        String connectionkey = msgJsonArray.getString(2);
        int timestamp = jsonObject.getInt("timestamp");

        JSONObject responseJson = new JSONObject();
        responseJson.put("type",Config.LOGIN_SUCCESS);
        responseJson.put("connectionkey",connectionkey);

        ctx.writeAndFlush(responseJson)
    } finally {
        frame.release();
    }
}