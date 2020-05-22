public long getmilifromdate(String datei) // 2015-11-21
    {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd);
            date = sdf.parse(datei);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date == null ? System.currentTimeMillis() : date.getTime();
    }