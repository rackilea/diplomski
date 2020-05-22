return complexRequest.post()
    .thenCompose(res -> {
        if (someCondition) throw new Step1Exception("Step 1 failed");
        // (...)    
    }).thenCompose(res -> {
        if (someAnotherCondition) throw new StepNException("Step N failed");
        // (...)    
    }).exceptionally(e -> ok("Got an error: " + e.getMessage()));