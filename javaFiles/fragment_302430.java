grammar K;

@parser::members {
  private boolean inbounds(Token t, int min, int max) {
    int n = Integer.parseInt(t.getText());
    return n >= min && n <= max;
  }
}

parse
  :  expr
  ;

expr
  :  Set Value1 integer1 {System.out.println("Value1 :: " + $integer1.text);}
  |  Set Value2 integer2 {System.out.println("Value2 :: " + $integer2.text);}
  ;

integer1
  :  Int {inbounds($Int, 1, 10000)}?
  ;

integer2
  :  Int {inbounds($Int, 0, 25999)}?
  ;

Value1 : 'value1';  
Value2 : 'value2';
Set    : 'set';
Int    : '0'..'9'+;
Space  : (' ' | '\t' | '\r' | '\n') {$channel=HIDDEN;};