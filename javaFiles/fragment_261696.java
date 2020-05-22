import org.nfunk.jep.JEP;

public class LinearEquationParser
{
    private double coefficient;
    private double constant;

    public static void main(String[] args)
    {
        runTest("3x = 5");
        runTest("3x +2*(6x-3) = 2 -4x");
        runTest("3x + 2*(6x -sin(3))=cos(2)-4*x*log(tan(43))");
    }

    private static void runTest(String s)
    {
        System.out.println("Input: "+s);

        LinearEquationParser p = new LinearEquationParser();
        p.process(s);

        System.out.println("Coefficient: "+p.getCoefficient());
        System.out.println("Constant   : "+p.getConstant());
        System.out.println();
    }

    public void process(String s)
    {
        JEP jep = new JEP();
        jep.setImplicitMul(true);
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.addVariable("x",  0.0);

        String s0 = s.substring(0, s.indexOf("="));
        String s1 = s.substring(s.indexOf("=")+1, s.length());

        jep.parseExpression(s0);
        if (jep.hasError())
        {
            throw new IllegalArgumentException(jep.getErrorInfo());
        }

        jep.addVariable("x",  0.0);
        double constant0 = jep.getValue();
        jep.addVariable("x",  1.0);
        double value0 = jep.getValue();

        jep.parseExpression(s1);
        if (jep.hasError())
        {
            throw new IllegalArgumentException(jep.getErrorInfo());
        }

        jep.addVariable("x",  0.0);
        double constant1 = jep.getValue();
        jep.addVariable("x",  1.0);
        double value1 = jep.getValue();

        constant = constant0 - constant1;
        coefficient = (value0 - constant0) - (value1-constant1);
    }

    public double getCoefficient()
    {
        return coefficient;
    }

    public double getConstant()
    {
        return constant;
    }

}