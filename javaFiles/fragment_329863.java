ArrayList<Object> list = new ArrayList<>();



        list.add(new A("MAY 23", 1, 3000$));

        list.add(new B("April27", 1, 2, 3400$));

        list.add(new C("New york" "March 28", 1000$, 2, 2));




Collections.sort(list, new Comparator<Object>() {

    @Override
    public int compare(Object l1, Object l2) {

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd", Locale.ENGLISH);

        Date d1=null;
        Date d2= null;

        try {
            d1=sdf.parse(String.valueOf((D)l1.getDate()));

             d2= sdf.parse(String.valueOf((D)l2.getDate()));

         } catch (ParseException e) {

            e.printStackTrace();
        }

        if(d1 != null && d1.after(d2)){

            return 1;

        }else if(d!=null && d1.before(d2)){

            return -1;
        }else return 0;