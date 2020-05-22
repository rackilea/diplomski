for (int i = 0; i < city.length - 1; i++) {
    for (int j = i + 1; j < city.length; j++) {
        if (city[i].getName().compareTo(city[j].getName()) > 1) {
            City temp_city = city[i];
            city[i] = city[j];
            city[j] = temp_city;
        }
    }
}