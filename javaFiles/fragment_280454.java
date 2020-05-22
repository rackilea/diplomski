SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
            Date d;
            try {
                d = fmt.parse(st);
            } catch (ParseException e) {

                e.printStackTrace();
                return null;
            }
            SimpleDateFormat prnt = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss");
            String newDate=prnt.format(d)