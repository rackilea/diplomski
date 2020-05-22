@Override
public void visit(VariableDeclarationExpr n, Object arg)
{      
    List <VariableDeclarator> myVars = n.getVars();
        for (VariableDeclarator vars: myVars){
            System.out.println("Variable Name: "+vars.getId().getName());
            }
}