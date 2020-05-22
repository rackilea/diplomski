PngReader pngr = FileHelper.createPngReader(new File(file));
pngr.readSkippingAllRows();
for (PngChunk c : pngr.getChunksList().getChunks()) {
      if (!ChunkHelper.isText(c))   continue;
      PngChunkTextVar ct = (PngChunkTextVar) c;
      String key = ct.getKey();
      String val = ct.getVal();
      // ... 
}