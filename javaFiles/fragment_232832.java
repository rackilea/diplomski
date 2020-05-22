private int getLengthOfLongest(List<Driver> drivers, Function<Driver, String> func) {
        return drivers.stream()
                .map(func)
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }