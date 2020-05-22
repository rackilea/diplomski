Properties properties = new Properties();
        properties.load(MY_INPUT_STREAM);
        int val1 = properties.get("val1");
        int val2 = properties.get("val2");
        int val3 = properties.get("val3");
        properties.put("val4", val1 + val2 + val3);