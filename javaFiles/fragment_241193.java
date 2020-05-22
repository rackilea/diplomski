try (InputStream inputStream = new URL(url).openStream();
     ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream);
     FileOutputStream fileOutputStream = new FileOutputStream(Bukkit.getServer().getUpdateFolderFile());
     FileChannel fileChannel = fileOutputStream.getChannel()) {

    fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

} catch (IOException ex) {
    ex.printStackTrace();
}