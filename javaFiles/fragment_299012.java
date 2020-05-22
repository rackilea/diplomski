package com.stackoverflow.infix;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

import org.junit.Test;

public class TestInfixPostfixEvaluator {

    @Test
    public void testWhole() {

        InfixPostfixEvaluator eval = new InfixPostfixEvaluator();

        String infixExpr = "5+50-10";
        List<String> expression = eval.split(infixExpr);
        Stack<String> stack = eval.convert2Postfix(expression);
        assertEquals(45, eval.evaluatePostfix(stack));

        infixExpr = "2-3+4";
        expression = eval.split(infixExpr);
        stack = eval.convert2Postfix(expression);
        assertEquals(3, eval.evaluatePostfix(stack));

        infixExpr = "305-303+4";
        expression = eval.split(infixExpr);
        stack = eval.convert2Postfix(expression);
        assertEquals(6, eval.evaluatePostfix(stack));

        infixExpr = "2+3";
        expression = eval.split(infixExpr);
        stack = eval.convert2Postfix(expression);
        assertEquals(5, eval.evaluatePostfix(stack));

        infixExpr = "2*5+5";
        expression = eval.split(infixExpr);
        stack = eval.convert2Postfix(expression);
        assertEquals(15, eval.evaluatePostfix(stack));

        infixExpr = "2*5/5*5";
        expression = eval.split(infixExpr);
        stack = eval.convert2Postfix(expression);
        assertEquals(10, eval.evaluatePostfix(stack));

        infixExpr = "4+2*16/4";
        expression = eval.split(infixExpr);
        stack = eval.convert2Postfix(expression);
        assertEquals(12, eval.evaluatePostfix(stack));

        infixExpr = "16*3/4+2";
        expression = eval.split(infixExpr);
        stack = eval.convert2Postfix(expression);
        assertEquals(14, eval.evaluatePostfix(stack));

    }

    @Test
    public void testSplit() {
        String exp = "15+20+84/205-1";
        LinkedList<String> a = new LinkedList<String>();

        StringTokenizer st = new StringTokenizer(exp, "+*/-", true);
        while (st.hasMoreTokens())
            a.add(st.nextToken());
        System.out.println(a.toString());
    }

}