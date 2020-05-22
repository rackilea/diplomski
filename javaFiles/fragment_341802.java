ServerEvaluationCall call = client.newServerEval()
        .xquery("cts:uris()");
    for ( EvalResult result : call.eval() ) {
        String uri = result.getString();
        System.out.println(uri);
    }