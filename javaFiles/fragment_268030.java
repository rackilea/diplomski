String status ="";

        JSONObject jsonObject = new JSONObject(response); //convert to json

        if (jsonObject.has("status")){ //check if has the key
            status = jsonObject.getString("status"); // get the value
        }else{

        }

        Log.d("TAG", status); // do sth with the value

        //Log => status