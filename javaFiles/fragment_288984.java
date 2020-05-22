private void addMissingSuperCall(final TypeElement element){
    final String className = element.getQualifiedName().toString();
    final JCClassDecl classDeclaration =
        // look up class declaration from a local map 
        this.findClassDeclarationForName(className);
    if(classDeclaration == null){
        this.error(element, "Can't find class declaration for " + className);
    } else{
        this.info(element, "Creating renderHead(response) method");
        final JCTree extending = classDeclaration.extending;
        if(extending != null){
            final String p = extending.toString();
            if(p.startsWith("com.myclient")){
                // leave it alone, we'll edit the super class instead, if
                // necessary
                return;
            } else{
                // @formatter:off (turns off eclipse formatter if configured)

                // define method parameter name
                final com.sun.tools.javac.util.Name paramName =
                    elementUtils.getName("response");
                // Create @Override annotation
                final JCAnnotation overrideAnnotation =
                    this.treeMaker.Annotation(
                        Processor.buildTypeExpressionForClass(
                            this.treeMaker,
                            elementUtils,
                            Override.class
                        ),
                        // with no annotation parameters
                        List.<JCExpression> nil()
                    );
                // public
                final JCModifiers mods =
                    this.treeMaker.Modifiers(Flags.PUBLIC,
                        List.of(overrideAnnotation));
                // parameters:(final IHeaderResponse response)
                final List<JCVariableDecl> params =
                    List.of(this.treeMaker.VarDef(this.treeMaker.Modifiers(Flags.FINAL),
                        paramName,
                        Processor.buildTypeExpressionForClass(this.treeMaker,
                            elementUtils,
                            IHeaderResponse.class),
                        null));

                //method return type: void
                final JCExpression returnType =
                    this.treeMaker.TypeIdent(TypeTags.VOID);


                // super.renderHead(response);
                final List<JCStatement> statements =
                    List.<JCStatement> of(
                        // Execute this:
                        this.treeMaker.Exec(
                            // Create a Method call:
                            this.treeMaker.Apply(
                                // (no generic type arguments)
                                List.<JCExpression> nil(),
                                // super.renderHead
                                this.treeMaker.Select(
                                    this.treeMaker.Ident(
                                        elementUtils.getName("super")
                                    ),
                                    elementUtils.getName("renderHead")
                                ),
                                // (response)
                                List.<JCExpression> of(this.treeMaker.Ident(paramName)))
                            )
                     );
                // build code block from statements
                final JCBlock body = this.treeMaker.Block(0, statements);
                // build method
                final JCMethodDecl methodDef =
                    this.treeMaker.MethodDef(
                        // public
                        mods,
                        // renderHead
                        elementUtils.getName("renderHead"),
                        // void
                        returnType,
                        // <no generic parameters>
                        List.<JCTypeParameter> nil(),
                        // (final IHeaderResponse response)
                        params,
                        // <no declared exceptions>
                        List.<JCExpression> nil(),
                        // super.renderHead(response);
                        body,
                        // <no default value>
                        null);

                // add this method to the class tree
                classDeclaration.defs =
                    classDeclaration.defs.append(methodDef);

                // @formatter:on turn eclipse formatter on again
                this.info(element,
                    "Created renderHead(response) method successfully");

            }
        }

    }
}