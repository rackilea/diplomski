JSONArray objJsonArray = null;
    FileWriter objJsonFileWriter = null;
    PlayerMasterJsonInfoBean objBean = null;

    try {
      objList.setFirst_name(getPlayerMaster.getFirst_name()); //<- Get the value from bean class then add to collection class
      objList.setLast_name(getPlayerMaster.getLast_name()); //<- Get the value from bean class then add to collection class
      objJsonArray = (JSONArray) JSONSerializer.toJSON(objList); //<- Then pass object here
      objJsonFileWriter = new FileWriter("D:\\MyJson.json");
      objJsonFileWriter.write(objJsonArray.toString());
      objJsonFileWriter.flush();
      objJsonFileWriter.close();
    } catch (JSONException jse) {
      jse.printStackTrace();
    }