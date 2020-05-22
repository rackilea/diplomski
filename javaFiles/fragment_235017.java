protected void writePage() throws IOException
{
    [...]
        List<TextPosition> line = new ArrayList<TextPosition>();
        [...]
            if(!overlap(positionY, positionHeight, maxYForLine, maxHeightForLine))
            {
                writeLine(normalize(line,isRtlDominant,hasRtl),isRtlDominant);
                line.clear();
                [...]
            }
............