List<String> l = new ArrayList<String>();
l.add("8:00 am");
l.add("8:32 am");
l.add("8:10 am");
l.add("1:00 pm");
l.add("3:00 pm");
l.add("2:00 pm");
Collections.sort(l, new Comparator<String>() {

    @Override
    public int compare(String o1, String o2) {
        try {
            return new SimpleDateFormat("hh:mm a").parse(o1).compareTo(new SimpleDateFormat("hh:mm a").parse(o2));
        } catch (ParseException e) {
            return 0;
        }
        }
    });
    System.out.println(l);