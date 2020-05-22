import javax.swing.SizeSequence;

public class Test
{
  static SizeSequence createLineMap(String s)
  {
    String[] lines = s.split("(?<=\n)");
    SizeSequence sseq = new SizeSequence(lines.length);
    for (int i = 0; i < lines.length; i++)
    {
      sseq.setSize(i, lines[i].length());
    }
    return sseq;
  }

  public static void main(String[] args) throws Exception
  {
    String input = "X2\nX\n4\n56XX";
    SizeSequence lineMap = createLineMap(input);
    String target = "X";
    int pos = -1;
    while ((pos = input.indexOf("X", pos+1)) != -1)
    {
      System.out.printf("'%s' found in line %d (index %d)%n",
          target, lineMap.getIndex(pos) + 1, pos);
    }
  }
}