package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.astesana.javaluator.*;

public class TreeBooleanEvaluator extends AbstractEvaluator<String> {
  /** The logical AND operator.*/
  final static Operator AND = new Operator("&&", 2, Operator.Associativity.LEFT, 2);
  /** The logical OR operator.*/
  final static Operator OR = new Operator("||", 2, Operator.Associativity.LEFT, 1);

  private static final Parameters PARAMETERS;

  static {
    // Create the evaluator's parameters
    PARAMETERS = new Parameters();
    // Add the supported operators
    PARAMETERS.add(AND);
    PARAMETERS.add(OR);
    // Add the parentheses
    PARAMETERS.addExpressionBracket(BracketPair.PARENTHESES);
  }

  public TreeBooleanEvaluator() {
    super(PARAMETERS);
  }

  @Override
  protected String toValue(String literal, Object evaluationContext) {
    return literal;
  }

  private boolean getValue(String literal) {
    if ("T".equals(literal) || literal.endsWith("=true")) return true;
    else if ("F".equals(literal) || literal.endsWith("=false")) return false;
    throw new IllegalArgumentException("Unknown literal : "+literal);
  }

  @Override
  protected String evaluate(Operator operator, Iterator<String> operands,
      Object evaluationContext) {
    List<String> tree = (List<String>) evaluationContext;
    String o1 = operands.next();
    String o2 = operands.next();
    Boolean result;
    if (operator == OR) {
      result = getValue(o1) || getValue(o2);
    } else if (operator == AND) {
      result = getValue(o1) && getValue(o2);
    } else {
      throw new IllegalArgumentException();
    }
    String eval = "("+o1+" "+operator.getSymbol()+" "+o2+")="+result;
    tree.add(eval);
    return eval;
  }

  public static void main(String[] args) {
    TreeBooleanEvaluator evaluator = new TreeBooleanEvaluator();
    doIt(evaluator, "T && ( F || ( F && T ) )");
    doIt(evaluator, "(T && T) || ( F && T )");
  }

  private static void doIt(TreeBooleanEvaluator evaluator, String expression) {
    List<String> sequence = new ArrayList<String>();
    evaluator.evaluate(expression, sequence);
    System.out.println ("Evaluation sequence for :"+expression);
    for (String string : sequence) {
      System.out.println (string);
    }
    System.out.println ();
  }
}