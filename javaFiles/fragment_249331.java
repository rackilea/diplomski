//features.add(builder.buildFeature(null));

 //add
 System.out.println("adding...");
 SimpleFeature feature = builder.buildFeature(null);
 ((Collection<SimpleFeature>) features).add(feature);