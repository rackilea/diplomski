try {
    ....
} catch(...) {
    ...
} finally {
    // This will guaranty you get all data:
    inputStream.close();
}