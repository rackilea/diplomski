for (int i = 0; i < lines.size();) {
        temp = lines.get(i).split(Character.toString(DELIMITER));
        int id = Integer.valueOf(temp[0]);
        String cityName = stripQuotes(temp[1]);
        String country = stripQuotes(temp[2]);
        int noofyeardata = Integer.valueOf(temp[3]);

        for (int j = (i + 1); j <= (i + noofyeardata); j++) {
           //your existing code
        }
        repository.add(new City(id, cityName, country, yearData));
        i += noofyeardata + 1;
    }
}