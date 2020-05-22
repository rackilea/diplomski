%{
private int keywordCount = 0;
public static void main(String argv[]) throws java.io.IOException
{
        MyLexer yy= new MyLexer(new FileReader("input"));
        while( yy.yylex() >= 0);
}
%}