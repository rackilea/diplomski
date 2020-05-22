r = resultChecker.poll();
if(r != null) {
    // we have result
} else {
    // result is not ready
    // try again later
}