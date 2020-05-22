// Assuming redis is running on port 32768 on localhost
    // insert some records
    Jedis jedis = new Jedis("localhost", 32768);
    jedis.set("foo1", "bar1");
    jedis.set("foo2", "bar2");
    jedis.set("foo3", "bar3");
    jedis.set("foo4", "bar4");
    jedis.set("foo5", "bar5");

    // first value of cursor must be "0"
    String cursor = "0";

    // fetch 2 keys in every scan
    ScanParams scanParams = new ScanParams().count(2);

    do {
        ScanResult<String> scanResult = jedis.scan(cursor, scanParams);

        System.out.println("Keys for cursor ---> " + cursor);
        scanResult.getResult().forEach((key) -> {
            System.out.println("Key = " + key);
        });

        cursor = scanResult.getCursor();
    } while (!"0".equals(cursor));