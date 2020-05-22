catch (ValidationException ve) {            

        JSONObject jsonObject = ve.toJSON();
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(jsonObject.toString(), JsonElement.class);

        return element;

    }