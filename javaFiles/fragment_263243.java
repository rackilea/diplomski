Primary:
  ParExpression
        NonWildcardTypeArguments (
            ExplicitGenericInvocationSuffix | this Arguments)
  this [Arguments]
  super SuperSuffix
  Literal
  new Creator
  Identifier { . Identifier }[ IdentifierSuffix]
  BasicType {[]} .class
  void.class