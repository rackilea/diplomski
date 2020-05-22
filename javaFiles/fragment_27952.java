class InitialisingVariableListener extends DefaultExecuteListener {
    @Override
    public void renderEnd(ExecuteContext ctx) {
        ctx.sql("SET @row_number = 0;" + ctx.sql());
    }
}