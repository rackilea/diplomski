//Use the JSON File included as a resource
 ClassLoader classLoader = SleepReader.class.getClassLoader();
 File dataFile = new File(classLoader.getResource("example.json").getFile());

 //Simple example of getting the Sleep Objects from that JSON
 new JsonArrayStreamDataSupplier<>(dataFile, Sleep.class) //Got the Stream
                .forEachRemaining(nightsRest -> {
                    System.out.println(nightsRest.toString());
                });