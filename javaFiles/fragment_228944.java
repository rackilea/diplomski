if(c != null) {
        if(c.getCount() > 0 && c.moveToFirst())
        {
            String name = c.getString(1);
            c.close();
            return name;
        }
        c.close();
    }
    return null;