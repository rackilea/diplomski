private final AtomicInteger attemptCounter = new AtomicInteger(0);

void whateverYourMethodIsCalled(String responseString) {
    int attemptId = attemptCounter.incrementAndGet();
    System.out.format("Beginning attempt: %d%n", attemptId);
    String chunkSizeAsString = responseString.split(DOUBLE_NEW_LINE)[1]
        .split(SINGLE_NEW_LINE)[0];
    System.out.format("In attempt %d, trying to get integer value of '%s', which is length %d%n",
         attemptId, chunkSizeAsString, chunkSizeAsString.length());
    Integer chunkSize = Integer.valueOf(chunkSizeAsString, 16); // this is line 109
    System.out.format("Ending attempt: %d%n", attemptId);
}