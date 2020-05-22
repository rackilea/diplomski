package org.matheclipse.core.examples;

import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;

public class SimplifySO55169181 {

    public static void main(String[] args) {
        try {
            ExprEvaluator util = new ExprEvaluator();
            IExpr result = util.eval("a * b + 5 * a + 5 + a + 6");
            // print: 11+6*a+a*b
            System.out.println(result.toString());
        } catch (SyntaxError e) {
            // catch Symja parser errors here
            System.out.println(e.getMessage());
        } catch (MathException me) {
            // catch Symja math errors here
            System.out.println(me.getMessage());
        }
    }
}