try (
    InputStream is = new FileInputStream("some file")
    ) {
}
catch (RelevantExceptionType e) {
    // Do something about it
}
finally {
    // This runs regardless of whether there was an exception
}