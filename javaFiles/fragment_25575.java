List sorted = l.stream().map(a->{
            try {
                return f.parse(a);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }).sorted().collect(Collectors.toList());