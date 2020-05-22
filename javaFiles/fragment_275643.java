public class MyPDFTextStripper extends PDFTextStripper
{
    public List<List<TextPosition>> myLines = new ArrayList<List<TextPosition>>();
    [...]
                if(!overlap(positionY, positionHeight, maxYForLine, maxHeightForLine))
                {
                    writeLine(normalize(line,isRtlDominant,hasRtl),isRtlDominant);
                    myLines.add(new ArrayList<TextPosition>(line));
                    line.clear();
                    [...]
                }