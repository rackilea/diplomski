private void correctChunkOffsets(IsoFile tempIsoFile, long correction) {
    List<Box> chunkOffsetBoxes = Path.getPaths(tempIsoFile, "/moov[0]/trak/mdia[0]/minf[0]/stbl[0]/stco[0]");
    for (Box chunkOffsetBox : chunkOffsetBoxes) {

        LinkedList<Box> stblChildren = new LinkedList<Box>(chunkOffsetBox.getParent().getBoxes());
        stblChildren.remove(chunkOffsetBox);

        long[] cOffsets = ((ChunkOffsetBox) chunkOffsetBox).getChunkOffsets();
        for (int i = 0; i < cOffsets.length; i++) {
            cOffsets[i] += correction;
        }

        StaticChunkOffsetBox cob = new StaticChunkOffsetBox();
        cob.setChunkOffsets(cOffsets);
        stblChildren.add(cob);
        chunkOffsetBox.getParent().setBoxes(stblChildren);
    }
}