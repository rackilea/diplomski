String currentPeriod = String.format("{call %s.testProc(?)}", params.getJsonObject("databaseInfo").getString("dbName"));
      String priorPeriod   = String.format("{call %s.testProc(?)}", params.getJsonObject("databaseInfo").getString("dbName"));
      String todayPeriod   = String.format("{call %s.testProc(?)}", params.getJsonObject("databaseInfo").getString("dbName"));
     JsonArray jsonArray = new JsonArray();


    database.dbObject().getConnectionObservable().subscribe(
            connection -> {
                resultSetObservable = Observable.combineLatest(firstCall, secCall, thirdCall)
     firstCall = connection.callWithParamsObservable(currentPeriod, new JsonArray().add(params.getString("testParams")),jsonArray )

      secCall = result -> connection.callWithParamsObservable(priorPeriod, new JsonArray().add(params.getString("testParams")), jsonArray )

     thirdCall = result -> connection.callWithParamsObservable(todayPeriod, new JsonArray().add(params.getString("testParams")),jsonArray )
                resultSetObservable.subscribe(firstRes, secRes, thirdRes -> {
                    handler.handle(ReportUtils.parseSQLResult(resultSet.getRows()));
                },error -> {
                    error.printStackTrace();
                },connection::close);

            },err -> {
                err.printStackTrace();
            }
    );