HashMap<String, Double> initialMap = new HashMap<String, Double>();
initialMap.put("price", 0.0d);
initialMap.put("pageCount", 0.0d);
initialMap.put("comicCount", 0.0d);

Observable.fromIterable(getMarvelComicsList()).
            map(new Function<MarvelComic, HashMap<String, Double>>() {
                @Override
                public HashMap<String, Double> apply(@NonNull MarvelComic marvelComic) {
                    HashMap<String, Double> map = new HashMap<String, Double>();
                    map.put("price", Double.valueOf(marvelComic.getPrice()));
                    map.put("pageCount", Double.valueOf(marvelComic.getPageCount()));
                    map.put("comicCount", Double.valueOf(marvelComic.getPageCount()));
                    return map;
                }
            })
            .scan(initialMap, 
            new BiFunction<HashMap<String, Double>, 
                    HashMap<String, Double>, HashMap<String, Double>>() {
                @Override
                public HashMap<String, Double> apply(
                         @NonNull HashMap<String, Double> inputMap, 
                         @NonNull HashMap<String, Double> newValueMap) {
                    double sum = inputMap.get("price")+newValueMap.get("price");
                    double count = inputMap.get("pageCount")
                        +newValueMap.get("pageCount");
                    double comicCount = inputMap.get("comicCount")
                        +newValueMap.get("comicCount");

                    HashMap<String, Double> map = new HashMap<String, Double>();
                    map.put("price", sum);
                    map.put("pageCount", count);
                    map.put("comicCount", comicCount);

                    return map;
                }
            })
            // etc.