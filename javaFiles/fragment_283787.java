for (MainSubjectsSimple mss: mains) {
    try {

        hm.put("id",mss.getId());
        hm.put("description", mss.getDescription());

    } catch (NoSuchMessageException e) {
        //hm.add(Integer.valueOf(mss.getId().toString(),