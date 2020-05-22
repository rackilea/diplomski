PsiExpression argument = expression.getArgumentList().getExpressions()[indexOfArgument];
argument = PsiUtil.skipParenthesizedExprDown(argument);
if (argument instanceof PsiReferenceExpression) {
  PsiElement target = ((PsiReferenceExpression)argument).resolve();
  if (target instanceof PsiVariable) {
    ((PsiVariable)target).getModifierList();
    // get annotations
  }
}