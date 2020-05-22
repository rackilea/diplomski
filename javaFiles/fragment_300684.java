// TestParser.jjt
PARSER_BEGIN(TestParser)

public class TestParser {
  public static void main(String[] args) throws ParseException {
    TestParser parser = new TestParser(new java.io.StringReader(args[0]));
    SimpleNode root = parser.program();
    root.dump("");
  }
}

PARSER_END(TestParser)

TOKEN :
{
   < OPAR  : "(" > 
 | < CPAR  : ")" >
 | < OBR   : "{" >
 | < CBR   : "}" >
 | < COL   : ":" >
 | < SCOL  : ";" >
 | < COMMA : "," >
 | < VAR   : "var" >
 | < EQ    : "=" > 
 | < CONST : "const" >
 | < ID    : ("_" | <LETTER>) ("_" | <ALPHANUM>)* >
}

TOKEN :
{
   < #DIGIT    : ["0"-"9"] >
 | < #LETTER   : ["a"-"z","A"-"Z"] >
 | < #ALPHANUM : <LETTER> | <DIGIT> >
}

SKIP : { " " | "\t" | "\r" | "\n" }

SimpleNode program() #PROGRAM :
{}
{
  (decl())* (function())* <EOF> {return jjtThis;}
}

void decl() :
{}
{
     var_decl()
  |  const_decl()
}

void var_decl() #VAR :
{}
{
  <VAR> id() <COL> id() <EQ> expr() <SCOL>
}

void const_decl() #CONST :
{}
{
  <CONST> id() <COL> id() <EQ> expr() <SCOL>
}


void function() #FUNCTION :
{}
{
  type() id() <OPAR> params() <CPAR> <OBR> /* ... */ <CBR>
}

void type() #TYPE :
{Token t;}
{
  t=<ID> {jjtThis.value = t.image;}
}

void id() #ID :
{Token t;}
{
  t=<ID> {jjtThis.value = t.image;}
}

void params() #PARAMS :
{}
{
  (param() (<COMMA> param())*)?
}

void param() #PARAM :
{Token t;}
{
  t=<ID> {jjtThis.value = t.image;}
}

void expr() #EXPR :
{Token t;}
{
  t=<ID> {jjtThis.value = t.image;}
}