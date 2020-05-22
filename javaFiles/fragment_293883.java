SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    Collections.sort(templateDirs, (o1, o2) -> {
        if (o1.get(3) == null || o2.get(3) == null)
            return 0;
        try {
            boolean b =  formatter.parse(o1.get(3)).before(formatter.parse(o2.get(3)));
            return b ? 1:-1 ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    });