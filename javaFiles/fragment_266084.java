ExecutorService executor = Executors.newFixedThreadPool(3);
    Future<List<?>> future1 = executor.submit(callable1);
    Future<List<?>> future2 = executor.submit(callable2);
    Future<List<?>> future3 = executor.submit(callable3);
    Future<List<?>> future4 = executor.submit(callable4);

    Map<String,List<?>> listOfWebsites = new HashMap<>();
    listOfWebsites.put("listaAutovit", future1.get());
    listOfWebsites.put("listaOlx", future2.get());
    listOfWebsites.put("listaPubli24", future3.get());
    listOfWebsites.put("listaAutoUncle", future4.get());

    return listOfWebsites;