import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;

public class Main {
  public static void main(String[] args) throws Exception {
    String source = "10 - 2 * (3 + 8)";
    ExpLexer lexer = new ExpLexer(new ANTLRStringStream(source));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    ExpParser parser = new ExpParser(tokens);
    ExpParser.eval_return returnValue = parser.eval();
    CommonTree tree = (CommonTree)returnValue.getTree();
    CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
    ExpWalker walker = new ExpWalker(nodes);
    ExpNode root = walker.eval();
    System.out.println(source + " = " + root.evaluate());
  }
}

interface ExpNode {
  double evaluate();
}

class NumberExp implements ExpNode {

  final double num;

  NumberExp(String s) {
    num = Double.parseDouble(s);
  }

  @Override
  public double evaluate() {
    return num;
  }
}

class AddExp implements ExpNode {

  final ExpNode left, right;

  AddExp(ExpNode a, ExpNode b) {
    left = a;
    right = b;
  }

  @Override
  public double evaluate() {
    return left.evaluate() + right.evaluate();
  }
}

class SubExp implements ExpNode {

  final ExpNode left, right;

  SubExp(ExpNode a, ExpNode b) {
    left = a;
    right = b;
  }

  @Override
  public double evaluate() {
    return left.evaluate() - right.evaluate();
  }
}

class MulExp implements ExpNode {

  final ExpNode left, right;

  MulExp(ExpNode a, ExpNode b) {
    left = a;
    right = b;
  }

  @Override
  public double evaluate() {
    return left.evaluate() * right.evaluate();
  }
}

class DivExp implements ExpNode {

  final ExpNode left, right;

  DivExp(ExpNode a, ExpNode b) {
    left = a;
    right = b;
  }

  @Override
  public double evaluate() {
    return left.evaluate() / right.evaluate();
  }
}

class UnaryExp implements ExpNode {

  final ExpNode exp;

  UnaryExp(ExpNode e) {
    exp = e;
  }

  @Override
  public double evaluate() {
    return -exp.evaluate();
  }
}