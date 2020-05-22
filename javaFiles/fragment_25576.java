SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-DD HH:mm");
        List<Car> sorted = cars.stream().sorted(
                (a,b)->
        {
            try {
                return f.parse(a.getDate()).compareTo(f.parse(b.getDate()));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return 0;
        }
        ).collect(Collectors.toList());