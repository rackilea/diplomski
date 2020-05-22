public void copyPartsBufferFile(InputStream input, Integer bufferSize, String fullPathDetiny) {

BufferedOutputStream stream = null;

    try {

        stream = new BufferedOutputStream(new FileOutputStream(new File(fullPathDetiny)));

        ReadableByteChannel rbc = Channels.newChannel(input);
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        byte[] bytes;

        while (rbc.read(buffer) >= 0) {
            buffer.flip();
            bytes = buffer.array();
            stream.write(bytes);
            buffer.clear();
        }

    } catch (FileNotFoundException e) {

    } catch (IOException e) {

    } catch (Exception e) {

    } finally {

    }

}