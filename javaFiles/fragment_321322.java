ASTBinaryOperation implements ASTNode
{
  ASTNode left, right;
  Operator op;

  Result visit()
  {
    Result lr = left.visit();
    Result rr = right.visit();

    return op.apply(lr, rr);
  }
}