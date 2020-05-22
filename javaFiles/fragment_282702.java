// Check all data is there
    if ((address == null) || address.equals("")
        || (comments == null) || comments.equals(""))
    {
            // Either the user did not fill out the form or this is the
            // first time they are visiting the page.
            Map<String,String> map = new HashMap<String,String>();
            map.put("page",page);
            ...
            return map;