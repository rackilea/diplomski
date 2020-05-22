protected void popOp() throws ParseException
{
    Operator op = ops.pop();

    if(op == implicitMul) {
        Node rhs = nodes.pop();
        Node lhs = nodes.pop();
        Node node = nf.buildOperatorNode(
                jep.getOperatorTable().getMultiply(), 
                lhs, rhs);
        nodes.push(node);
    }
    else if(op.isBinary()) {
        Node rhs = nodes.pop();
        Node lhs = nodes.pop();
        Node node = nf.buildOperatorNode(op, lhs, rhs);
        nodes.push(node);
    }
    else if(op.isUnary()) {
        Node lhs = nodes.pop();
        Node node = nf.buildOperatorNode(op, lhs);
        nodes.push(node);
    }
    else if(op.isTernary() && op instanceof TernaryOperator.RhsTernaryOperator ) {
        Operator op2 = ops.pop();
        if(!(op2 instanceof TernaryOperator ) || !((TernaryOperator) op2).getRhsOperator().equals(op)) {
            throw new ParseException(
                    MessageFormat.format(JepMessages.getString("configurableparser.ShuntingYard.NextOperatorShouldHaveBeenMatchingTernaryOp"),op2.getName())); //$NON-NLS-1$

        }

        Node rhs = nodes.pop();
        Node middle = nodes.pop();
        Node lhs = nodes.pop();
        Node node = nf.buildOperatorNode(op2, new Node[]{lhs,middle,rhs});
        nodes.push(node);
    }
    else {
        throw new ParseException(MessageFormat.format(JepMessages.getString("configurableparser.ShuntingYard.InvalidOperatorOnStack"),op.getSymbol())); //$NON-NLS-1$
    }
}