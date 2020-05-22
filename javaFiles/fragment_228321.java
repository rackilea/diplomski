if (matcher == null) {
    // No matchers available, create one
    // No lock needed, as it's not a drama to have a few more matchers in the queue
    Pattern pattern = Pattern.compile(regexp);
    matcher = pattern.matcher(value);
    matcherQueue.offer(matcher); // Don't add it to the queue here!
}