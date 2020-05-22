if (fieldType.getKind() != TypeKind.DECLARED) {
    processingEnv.getMessager().printMessage(
            Kind.ERROR, "Field cannot be a generic type.", field);
}
DeclaredType declaredFieldType = (DeclaredType) fieldType;
TypeElement fieldTypeElement = (TypeElement) declaredFieldType.asElement();