if ( constraintHelper.isBuiltinConstraint( annotationType ) ) {
    constraintDefinitionClasses.addAll( constraintHelper.getBuiltInConstraints( annotationType ) );
}
else {
    Class<? extends ConstraintValidator<?, ?>>[] validatedBy = annotationType
            .getAnnotation( Constraint.class )
            .validatedBy();
    constraintDefinitionClasses.addAll( Arrays.asList( validatedBy ) );
}