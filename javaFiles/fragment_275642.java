protected void writePage() throws IOException
{
    [...]
    for( int i = 0; i < charactersByArticle.size(); i++)
    {
        [...]
        List<TextPosition> line = new ArrayList<TextPosition>();
        [...]
        while( textIter.hasNext() )
        {
            [...]
            if( lastPosition != null )
            {
                [...]
                if(!overlap(positionY, positionHeight, maxYForLine, maxHeightForLine))
                {
                    writeLine(normalize(line,isRtlDominant,hasRtl),isRtlDominant);
                    line.clear();
                    [...]
                }
............