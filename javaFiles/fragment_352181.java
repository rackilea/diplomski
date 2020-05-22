// use keys() iterator, you don't need to know what keys are there/missing
    Iterator<String> iter = response.keys();
    while (iter.hasNext()) {
        String key = iter.next();
        JSONObject lightObject = response.getJSONObject(key); 
        System.out.println("key: " + key + ", OBJECT " + lightObject);

        // you can check if the object has a key before you access it
        if (lightObject.has("bri")) {
            bri = lightObject.getInt("bri");
        }

        if (lightObject.has("sat")) {
            sat = lightObject.getInt("sat");
        }

        if (lightObject.has("hue")) {
            hue = lightObject.getInt("hue");
        }

        if (lightObject.has("name")) {
            name = lightObject.getString("name")
        }

        Light light = new Light(key, name, description, on, bri, sat, hue);
        mLightList.add(light);
    }

    mLightAdapter.notifyDataSetChanged();