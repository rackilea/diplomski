public int compare(final Object[] entry1, final Object[] entry2) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                time1 = sdf.parse(entry1[3].toString());
                time2 = sdf.parse(entry2[3].toString());

                return time2.compareTo(time1);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

        }
    });