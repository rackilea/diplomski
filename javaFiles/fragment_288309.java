boolean superTypeValid = true;
final TypeMirror parent = el.getSuperClass();
if(!parent.getKind().equals(TypeKind.DECLARED)) {
    messager.printMessage(Kind.ERROR, "May only inherit from a class; not enums, annotations or other declared kinds.", annotatedElement, mirror);
    superTypeValid = false;
} else {
    final DeclaredType parentType = (DeclaredType)parent;
    final Element parentEl = parentType.asElement();
    if(!parentEl.getKind().equals(ElementKind.CLASS)) {
        messager.printMessage(Kind.ERROR, "May only inherit from a class; not enums, annotations or other declared kinds.", annotatedElement, mirror);
        superTypeValid = false;
    }
}
...
if(superTypeValid) {
    if(typeUtils.isSameType(parent, elUtils.getTypeElement("java.lang.Object").asType())) {
        messager.printMessage(Kind.ERROR, "Inherit must not be set to true if the class doesn't extend.", annotatedElement, mirror);
        valid = false;
    } else {
        ...
    }
}