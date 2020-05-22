String coords = "28.56402,79.93652a27.27569,26.16394a42.69404,20.02808a48.61541,51.37207a";
 String[] coors = coords.split("a");
 final List<List<Double>> polygons = new ArrayList<>();

 for(int i= 0;i<coors.length;i++)
    {
       String[] coo = coors[i].split(",");
       System.out.println("coors" + i + " : " + coors[i]);
       polygons.add(Arrays.asList(Double.parseDouble(coo[0]),Double.parseDouble(coo[1])));
    }

 Bson query = Filters.geoWithinPolygon("loc", polygons);
 FindIterable<Document> results = this.getMongoCollectionProcessor().queryDocument(query);
 MongoCursor<Document> resultsIterator = results.iterator();