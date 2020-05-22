private static class IfStmtVisitor extends VoidVisitorAdapter<Void> {
    int i = 0;

    @Override
    public void visit(IfStmt n, Void arg) 
    {
        cyclomaticCount(n);
    }

    private void cyclomaticCount(IfStmt n)
    {
        // one for the if-then
        i++;
        Statement elseStmt = n.getElseStmt();
        if (elseStmt != null)
        {
            if (  IfStmt.class.isAssignableFrom(elseStmt.getClass())) 
            {
                cyclomaticCount((IfStmt) elseStmt);
            }
            else
            {
                // another for the else
                i++;
            }
        }
    }

    public int getNumber() {
        return i;
    }
}