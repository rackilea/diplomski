public interface Entry {
  int evaluate();
}
public class Value implements Entry {
  private int value;
  public Value( int value ){
    this.value = value;
  }
  public int  evaluate(){
    return value;
  }
}
public class Operation implements Entry {
  private char operator;
  private Entry left;
  private Entry right;
  public Operation( char operator, Entry left, Entry right ){
    this.operator = operator;
    this.left = left;
    this.right = right;
  }
  public int  evaluate(){
    int l = left.evaluate();
    int r = right.evaluate();
    switch(operator){
    case '+':
      return l + r;
    case '-':
      return l - r;
    case '*':
      return l * r;
    case '/':
      return l / r;
    }
    throw new IllegalStateException( "operator " + operator );
  }
}
public class Parser {
  private Stack<Entry> stack = new Stack<>();
  Pattern pat = Pattern.compile( "[-+*/]" );
  Scanner scanner;
  public void parse( String ex ){
    scanner = new Scanner( ex );
    while( scanner.hasNext() ){
      while( scanner.hasNextInt() ){
        stack.push( new Value( scanner.nextInt() ) );
      }
      while( scanner.hasNext( pat ) ){
        char op = scanner.next( pat ).charAt( 0 );
        Entry right = stack.pop();
        Entry left = stack.pop();
        stack.push( new Operation( op, left, right ) );
      }
    }
  }
  public Entry get(){
    return stack.pop();
  }
}