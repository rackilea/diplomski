final InputStream in = whateverIsNeeded;
try {
    workWith(in);
} finally {
    in.close();
}