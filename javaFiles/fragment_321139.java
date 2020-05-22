JSONObject jObject;
    try {
        if (message != null && !message.equals("") {
          jObject = new JSONObject(message);
          //objectId = jObject.getString("id");
          time = jObject.getString("time");
          msg = jObject.getString("title");
          title = jObject.getString("msg");
          GCMMessage gcmMessage = new GCMMessage();

          //gcmMessage.setMsg_id(1);
          gcmMessage.setMsg_body(msg);
          gcmMessage.setMsg_title(title);
          gcmMessage.setType(0);
          gcmMessage.setDateTime(time);

          DatabaseUtil.insertMessage(context, gcmMessage);
        }

      }        
      catch (JSONException e) {
        e.printStackTrace();
      }