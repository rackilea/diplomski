boolean success = false;
try {
    somethingThatMayThrowAnException();
    success = true;
} catch (...) {
    ...
}
if (success) {
    somethingElseAfterwards();
}