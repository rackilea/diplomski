try (OutputStream out = channelSftp.put("/some/remote/file")) {
    OutputStreamWriter writer = new OutputStreamWriter(out);
    writer.write("some text");
} catch (IOException e) {
    ....
}