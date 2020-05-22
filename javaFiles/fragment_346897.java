class ConstCheckVisitor extends ASTVisitor {

    @Override
    public boolean visit(MethodInvocation methodInvocation) {    
        if (isConst(methodInvocation.getExpression())) {
            if (isConst(methodInvocation.resolveMethodBinding().getMethodDeclaration()))
                reportInvokingNonConstMethodOnConstSubject(methodInvocation);
        }

        return true;
    }

    @Override
    public boolean visit(Assignment assignment) {
        if (isConst(assignment.getLeftHandSide())) {
            if ( /* assignment to @Const value is not acceptable in the current situation */ )
                reportAssignmentToConst(assignment.getLeftHandSide());

            // FIXME: I assume here that aliasing a @Const value to
            //        another @Const value is acceptable. Is that right?

        } else if (isImplicitelyConst(assigment.getLeftHandSide())) {
            reportAssignmentToImplicitConst(assignment.getLeftHandSide());        

        } else if (isConst(assignment.getRightHandSide())) {
            reportAliasing(assignment.getRightHandSide());
        }

        return true;
    }

    private boolean isConst(Expression expression) {
        if (expression instanceof FieldAccess)
            return (isConst(((FieldAccess) expression).resolveFieldBinding()));

        if (expression instanceof SuperFieldAccess)
            return isConst(((SuperFieldAccess) expression).resolveFieldBinding());

        if (expression instanceof Name)
            return isConst(((Name) expression).resolveBinding());

        if (expression instanceof ArrayAccess)
            return isConst(((ArrayAccess) expression).getArray());

        if (expression instanceof Assignment)
            return isConst(((Assignment) expression).getRightHandSide());

        return false;
    }

    private boolean isImplicitConst(Expression expression) {
        // Check if field is actually accessed through a @Const chain
        if (expression instanceof FieldAccess)
            return isConst((FieldAccess expression).getExpression()) ||
                   isimplicitConst((FieldAccess expression).getExpression());

        // FIXME: Not sure about the effect of MethodInvocation, assuming
        //        that its subject is const or implicitly const

        return false;
    }

    private boolean isConst(IBinding binding) {
        if ((binding instanceof IVariableBinding) || (binding instanceof IMethodBinding))
            return containsConstAnnotation(binding.getAnnotations());

        return false;
    }
}