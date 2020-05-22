import java.util.ArrayList;

public class Test
{
    public static enum Operation { MULTIPLY, DIVIDE, ADD, SUBTRACT };
    abstract static class MathNode {
        public abstract double calc();
        public abstract String toString();
        public abstract boolean set( final MathNode left, final MathNode right, final Operation op );
    }
    static class ElementNode extends MathNode {
        private final double value;
        public ElementNode( final double v ) {
            this.value = v;
        }
        public double calc() {
            return value;
        }
        public String toString() {
            return Double.toString( value );
        }
        public boolean set( final MathNode left, final MathNode right, final Operation op ){
            return false;
        }
    }
    static class SumNode extends MathNode {
        public MathNode left = null;
        public MathNode right = null;
        public final Operation op;
        public SumNode( final Operation op ){
            this.op = op;
        }
        public boolean set( final MathNode left, final MathNode right, final Operation op ){
            if ( this.op == op )
            {
                this.left = left;
                this.right = right;
                return true;
            }
            return false;
        }
        public double calc() {
            final double l = left  == null ? 0 : left.calc();
            final double r = right == null ? 0 : right.calc();
            switch ( this.op ){
            case MULTIPLY:  return l * r;
            case DIVIDE:    return l / r;
            case SUBTRACT:  return l - r;
            default:        return l + r;
            }
        }
        public String toString(){
            final String l = left  == null?"0":left.toString();
            final String r = right == null?"0":right.toString();
            switch ( this.op ){
            case MULTIPLY:  return "( " + l + " * " + r + " )";
            case DIVIDE:    return "( " + l + " / " + r + " )";
            case SUBTRACT:  return "( " + l + " - " + r + " )";
            default:        return "( " + l + " + " + r + " )";
            }
        }
    }
    public static ArrayList<MathNode> tokenize( final String sum )
    {
        int i = 0,
            p = 0;
        final int l = sum.length();
        final ArrayList<MathNode> tokens = new ArrayList<MathNode>();
        while ( i < l )
        {
            final SumNode sn;
            switch ( sum.charAt(i) ){
            case '*':   sn = new SumNode( Operation.MULTIPLY ); break;
            case '/':   sn = new SumNode( Operation.DIVIDE );       break;
            case '+':   sn = new SumNode( Operation.ADD );      break;
            case '-':   sn = new SumNode( Operation.SUBTRACT ); break;
            default:
                // TODO: Add something to check if number is valid
                ++i; 
                continue;
            }
            // TODO: Add something to check for zero-width numbers 
            final double value = Double.parseDouble( sum.substring( p, i ) );
            p = ++i;
            tokens.add( new ElementNode( value ) );
            tokens.add( sn );
        }
        // TODO: Add something to check for zero-width numbers
        final double value = Double.parseDouble( sum.substring( p ) );
        tokens.add( new ElementNode( value ) );
        return tokens;
    }
    public static void makeTree( final ArrayList<MathNode> tokens, final Operation op ){
        for ( int i = tokens.size() - 2; i >= 1; --i )
        {
            final MathNode node = tokens.get( i );
            if ( node.set( tokens.get(i-1), tokens.get(i+1), op) )
            {
                tokens.remove( i + 1 );
                tokens.remove( i - 1 );
                --i;
            }
        }
    }
    public static void main(final String[] args) {
        final String sum = "23.2-5.2*4.4/2.2+14";
        final ArrayList<MathNode> tokens = tokenize( sum );
        makeTree( tokens, Operation.DIVIDE );
        makeTree( tokens, Operation.MULTIPLY );
        makeTree( tokens, Operation.SUBTRACT );
        makeTree( tokens, Operation.ADD );
        final MathNode sum_tree = tokens.get(0);
        System.out.println( sum_tree + " = " + sum_tree.calc() );
    }
}