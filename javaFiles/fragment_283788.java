List hms = new ArrayList();

     for (MainSubjectsSimple mss: mains) {
        try {
            HashMap hm = new HashMap();

            hm.put("id",mss.getId());
            hm.put("description", mss.getDescription());

            hms.add(hm);

        } catch (NoSuchMessageException e) {
            //hm.add(Integer.valueOf(mss.getId().toString(), translate(mss.getTranslationCode(),new Locale("fi")));
        }
    }

    ...

    try {
        _json = HtmlEntityEncoder.encode(JsonUtils.javaToStr(hms));

    } catch (Exception e) {

    }