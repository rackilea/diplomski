public CsdlEntitySet getEntitySet(...) throws ... {
...
    return new CsdlEntitySet()
        .setName(...)
        .setType(...)
        .setAnnotations(Arrays.asList(new CsdlAnnotation()
            .setTerm("termName").setExpression(
                new CsdlConstantExpression(CsdlConstantExpression
                    .ConstantExpressionType.String, "someInfo"))));
...
}