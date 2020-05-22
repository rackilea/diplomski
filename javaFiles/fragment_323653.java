public static boolean isInjectionAttribute(@DottedClassName String annotationClass) {
    if (annotationClass.startsWith("javax.annotation.")
            || annotationClass.startsWith("javax.ejb")
            || annotationClass.equals("org.apache.tapestry5.annotations.Persist")
            || annotationClass.equals("org.jboss.seam.annotations.In")
            || annotationClass.startsWith("javax.persistence")
            || annotationClass.endsWith("SpringBean")
            || annotationClass.equals("com.google.inject.Inject")
            || annotationClass.startsWith("com.google.") && annotationClass.endsWith(".Bind")
            && annotationClass.hashCode() == -243168318
            || annotationClass.startsWith("org.nuxeo.common.xmap.annotation")
            || annotationClass.startsWith("com.google.gwt.uibinder.client")
            || annotationClass.startsWith("org.springframework.beans.factory.annotation")
            || annotationClass.equals("javax.ws.rs.core.Context")) {
        return true;
    }
    int lastDot = annotationClass.lastIndexOf('.');
    String lastPart = annotationClass.substring(lastDot + 1);
    if (lastPart.startsWith("Inject")) {
        return true;
    }
    return false;
}