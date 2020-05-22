@Override
public Node visitEqCond(EqCondNode node){
    CondNode left = (CondNode) visit(node.left);
    CondNode right = (CondNode) visit(node.right);

    if(left.type.equals("num") && right.type.equals("num") && left.typeCorrect && right.typeCorrect){
        node.type = "bool";
    }
    else{
        node.typeCorrect = false;
        if(!left.type.equals("num")){
            err.TypeNotApplicableInOperationError(left.type, node.operator, node.lineNumber);
        }
        if(!right.type.equals("num")){
            err.TypeNotApplicableInOperationError(right.type, node.operator, node.lineNumber);
        }
    }
    return node;
}