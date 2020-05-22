ArrayList<String> datelist=new ArrayList<>(); 
        datelist.add("October 09, 2019");
        datelist.add("August 20, 2018");
        datelist.add("October 09, 2019");
        datelist.add("August 31, 2019");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.US);
        String maxDate = datelist.stream()
                .map(d -> LocalDate.parse(d, dtf))
                .max(Comparator.comparing(LocalDate::toEpochDay))
                .get().format(dtf);
        System.out.println(maxDate);