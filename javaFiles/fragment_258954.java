public class Example {

    public static void main(String[] args) throws FileNotFoundException, XPathExpressionException {
        String abc = "<Tags  Value = '635' Type = 'Number'/>";
        InputSource doc = new InputSource(new StringReader(abc));
        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression expr = xPath.compile("/Tags/@Value");
        System.out.println(expr.evaluate(doc)); // 635
    }

}