for (VariableElement field : fields) {
    TypeMirror fieldType = field.asType();
    String fullTypeClassName = fieldType.toString();
    if (!String.class.getName().equals(fullTypeClassName)) {
        processingEnv.getMessager().printMessage(
                Kind.ERROR, "Field type must be java.lang.String", field);
    }
}