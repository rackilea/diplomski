// Build a session read request
        SessionReadRequest readRequest = new SessionReadRequest.Builder()
                .setTimeInterval(startTime, endTime, TimeUnit.MILLISECONDS)
                .read(DataType.TYPE_SPEED)
                .setSessionName(SAMPLE_SESSION_NAME)
                .build();


// Invoke the Sessions API to fetch the session with the query and wait for the result
                    // of the read request.
                    SessionReadResult sessionReadResult =
                            Fitness.SessionsApi.readSession(mClient, readRequest)
                                    .await(1, TimeUnit.MINUTES);

                    // Get a list of the sessions that match the criteria to check the result.
                    Log.i(TAG, "Session read was successful. Number of returned sessions is: "
                            + sessionReadResult.getSessions().size());
                    for (Session session : sessionReadResult.getSessions()) {
                        // Process the session
                        dumpSession(session);

                        // Process the data sets for this session
                        List<DataSet> dataSets = sessionReadResult.getDataSet(session);
                        for (DataSet dataSet : dataSets) {
                            dumpDataSet(dataSet);
                        }
                    }