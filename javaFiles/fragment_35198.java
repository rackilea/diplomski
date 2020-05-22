if(c != null) {
    try {
        if (c.getCount() > 0) {
            c.moveToFirst();
            return c.getInt(c.getColumnIndexOrThrow(fieldName));
        }
    }
    finally {
        c.close();
    }
}