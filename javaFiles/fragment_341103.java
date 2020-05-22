public Observable<City> getCityFromFile(String cityName){
      return Observable.defer(() -> {
         try {
            InputStream is = assetManager.open(FILE_NAME);
            Scanner scanner = new Scanner(is);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.toLowerCase().contains(cityName.toLowerCase())) {
                    String[] cityParams = line.split("\t");
                    City city = new City();
                    city.setId(Long.parseLong(cityParams[0]));
                    city.setName(cityParams[1]);
                    return Observable.just(city);
                }
            }
        } catch (IOException e) {
             return Observable.error(e);
        }

        return Observable.empty(); // or Observable.error(new NotFoundException());
    });
}