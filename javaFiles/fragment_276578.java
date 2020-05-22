bool success = true;
try {
    something();
} catch (Exception e) {
    success = false;
    // other exception handling
}
if (success) {
    // equivalent of Python else goes here
}