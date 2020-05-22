import net.sf.saxon.expr.StaticProperty;
import net.sf.saxon.expr.StringLiteral;
import net.sf.saxon.sxpath.IndependentContext;
import net.sf.saxon.trans.XPathException;
import net.sf.saxon.om.StructuredQName;
import net.sf.saxon.expr.Expression;
import net.sf.saxon.expr.ExpressionParser;

public boolean dependsOnContext(final String expression) {
  final ExpressionParser expressionParser = new ExpressionParser();
  final IndependentContext context = new IndependentContext() {

    @Override
    public Expression bindVariable(final StructuredQName qName) throws XPathException {
      try {
        return super.bindVariable(qName);
      }
      catch (XPathException e) {
        //This assumes no variables are bound since no configuration is supplied to IndependentContext
        return new StringLiteral("Dummy");
      }
    }
  };
  try {
    Expression parsedExpression = expressionParser.parse(expression, 0, Token.EOF, -1, context);
    return ((parsedExpression.getDependencies() & (StaticProperty.DEPENDS_ON_CONTEXT_DOCUMENT | StaticProperty.DEPENDS_ON_CONTEXT_ITEM)) == 0);
  }
  catch (XPathException e) {
    //Handle XPath exception if expression is malformed
  }
}