@Override
    public boolean visit(FieldAccess fieldAccess) {
        // FieldAccess :: <expression>.<name>

        // First descend on the "subject" of the field access
        fieldAccess.getExpression().accept(this);

        // Then append the name of the accessed field itself
        this.path.append(fieldAccess.getName().getIdentifier());

        return false;
    }

    @Override
    public boolean visit(MethodInvocation methodInvocation) {
        // MethodInvocation :: <expression>.<methodName><<typeArguments>>(arguments)

        // First descend on the "subject" of the method invocation
        methodInvocation.getExpression().accept(this);

        // Then append the name of the accessed field itself
        this.path.append(methodAccess.getName().getIdentifier() + "()");

        return false;
    }

    @Override
    public boolean visit(ThisExpression thisExpression) {
        // ThisExpression :: [<qualifier>.] this

        // I will ignore the qualifier part for now, it will be up
        // to you to determine if it is pertinent
        this.path.append("this");

        return false;
    }