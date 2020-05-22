JSONObject jsonObject = ParseUser.getCurrentUser().getJSONObject("checklistData");
    String id = dataRecord.getID();
    Boolean checkIDValue = jsonObject.optString(id).equals("true");


    checkBox.setTag(getItem(position));

    if (checkIDValue) {

        checkBox.setChecked(true);

    } else {

        checkBox.setChecked(false);

    }