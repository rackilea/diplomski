@Override
    public boolean visit(MethodInvocation methodInvocation) {
        // MethodInvocation :: <expression>.<methodName><<typeArguments>>(arguments)

        // First descend on the "subject" of the method invocation
        methodInvocation.getExpression().accept(this);

        // Then append the name of the accessed field itself
        this.path.append(methodAccess.getName().getIdentifier() + "()");

        // Now deal with method arguments, each within its own, distinct access chain
        for (Expression arg : methodInvocation.getArguments()) {
            LinearPath orginalPath = this.path;
            this.path = new LinearPath();

            arg.accept(this);

            this.collectedPaths.append(this.path);
            this.path = originalPath;
        }

        return false;
    }