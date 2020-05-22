for(String query: qrys) {
    Stopwatch timer = Stopwatch.createUnstarted();
    try {
        timer.start();
        resQryES = methodforQrys(url, query);   // query result is saved in the iterable Map resQryES
        timer.stop();

        out.println("Query: " + query);
        out.println("Query execution time: " + timer);
        out.println("Query Results : " + resQryES);


    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }

}


out.close();