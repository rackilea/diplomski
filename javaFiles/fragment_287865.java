Stubber deleteStubber = null;
    if (numOfFailures > 0) {
        deleteStubber = PowerMockito.doThrow(new NullPointerException("Testing"));
        for (int i = 1; i < numOfFailures; i++) {
            deleteStubber = deleteStubber.doThrow(new NullPointerException("Testing"));
        }
    }
    deleteStubber.doNothing().when(request).call();