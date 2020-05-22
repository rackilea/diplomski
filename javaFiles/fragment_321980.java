PARSER_BEGIN(CommentStripParser)

public class CommentStripParser {
  public static void main(String[] args) throws Exception {
    java.io.FileInputStream file = new java.io.FileInputStream(new java.io.File(args[0]));
    CommentStripParser parser = new CommentStripParser(file);
    parser.parse();
  }
}

PARSER_END(CommentStripParser)

TOKEN :
{
  < OTHER : ~[] >
}

SKIP :
{
  < "//" (~["\r", "\n"])* >
| < "/*" > : ML_COMMENT_STATE
}

<ML_COMMENT_STATE> SKIP :
{
  < "*/" > : DEFAULT
| < ~[] >   
}

void parse() :
{
  Token t;
}
{
  ( t=<OTHER> {System.out.print(t.image);} )* <EOF>
}