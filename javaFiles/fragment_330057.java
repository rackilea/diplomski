if (countResponse.getResponse().next()) {
        int count = countResponse.getResponse().getInt("count");
        String[] array = new String[count];
        Logger.debug("count: " + count);

        for (int i = 0; i < count; i++) {
            if (response.getResponse().next()) {
                Logger.debug("i: " + i);
                array[i] = response.getResponse().getString(1);
            }
        }
        return array;
    }