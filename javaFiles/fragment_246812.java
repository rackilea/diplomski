// -- Get method template
    CtMethod dummyMethod = liveClass.getMethods()[2];
    // -- Get the annotation
    AttributeInfo parameterAttributeInfo = dummyMethod.getMethodInfo().getAttribute(ParameterAnnotationsAttribute.visibleTag);
    ConstPool parameterConstPool = parameterAttributeInfo.getConstPool();
    ParameterAnnotationsAttribute parameterAtrribute = ((ParameterAnnotationsAttribute) parameterAttributeInfo);
    Annotation[][] paramArrays = parameterAtrribute.getAnnotations();
    Annotation[] addAnno = paramArrays[0];
    //-- Edit the annotation adding values
    addAnno[0].addMemberValue("value", new StringMemberValue("This is the value of the annotation", parameterConstPool));
    addAnno[0].addMemberValue("required", new BooleanMemberValue(Boolean.TRUE, parameterConstPool));
    paramArrays[0] = addAnno;
    parameterAtrribute.setAnnotations(paramArrays);