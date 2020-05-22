try {
        var2 = (String) bin.getClass().getField("classVar").get(bin);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }