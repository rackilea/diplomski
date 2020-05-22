baos = new ByteArrayOutputStream();

AudioSystem.write(
       ais
       ,AudioFileFormat.Type.WAVE
       ,baos);

audioInByteArray = baos.toByteArray();