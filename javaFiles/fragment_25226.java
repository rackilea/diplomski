public class JpaAnnotationMover extends AbstractProcessor<CtMethod> {

    Pattern p1 = Pattern.compile("return.*this\\.(.*?)$");
    Pattern p2 = Pattern.compile("return(.*?)$");

    @Override
    public boolean isToBeProcessed(CtMethod method) {
        return isInEntity(method) && isAGetter(method) && hasOneStatement(method) && !isTransient(method);
    }

    @Override
    public void process(CtMethod ctMethod) {
CtType parentClass = ctMethod.getParent(CtType.class);
        String fieldName = getFieldName(ctMethod);

        if (fieldName == null) {
            log.warn(String.format("expected field name for %s not found.", ctMethod.getSimpleName()));
            return;
        }

        CtField field = parentClass.getField(fieldName);
        if (field == null) {
            log.warn(String.format("Expected field %s not found.", fieldName));
            return;
        }

        for (CtAnnotation<? extends Annotation> annotation : ctMethod.getAnnotations()) {
            field.addAnnotation(annotation);
        }

        parentClass.removeMethod(ctMethod);
        log.info(String.format("Processed method %s:%s", parentClass.getSimpleName(), ctMethod.getSimpleName()));

        // find corresponding setter
        String setterName = "set" + WordUtils.capitalize(fieldName);

        @SuppressWarnings("unchecked") CtMethod setter = parentClass
                .getMethod(getFactory().Type().createReference("void"), setterName, ctMethod.getType());

        if (setter == null) {
            log.warn(String.format("Unable to find setter for %s", fieldName));
            return;
        }

        parentClass.removeMethod(setter);

        if (!parentClass.hasAnnotation(Data.class)) {
            parentClass.addAnnotation(getFactory().createAnnotation(getFactory().Type().createReference(Data.class)));
        }
}

private Boolean isInEntity(CtMethod method) {
        CtType parentClass = method.getParent(CtType.class);
        return parentClass.hasAnnotation(Entity.class);
    }

    private Boolean isAGetter(CtMethod method) {
        return method.getSimpleName().contains("get");
    }

    private Boolean hasOneStatement(CtMethod method) {
        return method.getBody().getStatements().size() == 1;
    }

    private Boolean isTransient(CtMethod method) {
        return method.hasAnnotation(Transient.class);
    }

    private String getFieldName(CtMethod method) {
        String statement = method.getBody().getLastStatement().toString();
        Matcher m = p1.matcher(statement);
        Matcher m2 = p2.matcher(statement);
        return m.matches() ? m.group(1).trim() : m2.matches() ? m2.group(1).trim() : null;
    }
}