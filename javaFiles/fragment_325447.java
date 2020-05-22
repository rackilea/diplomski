try {
        Object object = obj.opt(ModelConstants.PETS);
        if (object instanceof JSONArray) {
            ArrayList<Pet> petList = new ArrayList<Pet>();
            JSONArray msgList = (JSONArray) object;
            for (int i = 0; i < msgList.length(); i++) {
                Pet pet = new Pet();
                JSONObject petsJSONObj  = msgList.getJSONObject(i);
                String pet_id = petsJSONObj.getString(ModelConstants.PET_ID);
                pet.setPet_id(pet_id);
                String pet_species = petsJSONObj
                        .getString(ModelConstants.PET_MANUFACTURER);
                pet.setPet_species(pet_species);
                ......
                petList.add(pet);
            }
        }
        om.setPetList(petList);
    } catch (Exception e) {
        e.printStackTrace();
    }