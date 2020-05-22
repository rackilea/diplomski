for (String string : set) {
        try {
            obj = (JSONObject) root.get(string);
        } catch (ClassCastException e) {
          // no need to do anything here
        }
    }