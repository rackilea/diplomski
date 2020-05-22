PDField removeField(PDDocument document, String fullFieldName) throws IOException {
    PDDocumentCatalog documentCatalog = document.getDocumentCatalog();
    PDAcroForm acroForm = documentCatalog.getAcroForm();

    if (acroForm == null) {
        System.out.println("No form defined.");
        return null;
    }

    PDField targetField = null;

    for (PDField field : acroForm.getFieldTree()) {
        if (fullFieldName.equals(field.getFullyQualifiedName())) {
            targetField = field;
            break;
        }
    }
    if (targetField == null) {
        System.out.println("Form does not contain field with given name.");
        return null;
    }

    PDNonTerminalField parentField = targetField.getParent();
    if (parentField != null) {
        List<PDField> childFields = parentField.getChildren();
        boolean removed = false;
        for (PDField field : childFields)
        {
            if (field.getCOSObject().equals(targetField.getCOSObject())) {
                removed = childFields.remove(field);
                parentField.setChildren(childFields);
                break;
            }
        }
        if (!removed)
            System.out.println("Inconsistent form definition: Parent field does not reference the target field.");
    } else {
        List<PDField> rootFields = acroForm.getFields();
        boolean removed = false;
        for (PDField field : rootFields)
        {
            if (field.getCOSObject().equals(targetField.getCOSObject())) {
                removed = rootFields.remove(field);
                break;
            }
        }
        if (!removed)
            System.out.println("Inconsistent form definition: Root fields do not include the target field.");
    }

    removeWidgets(targetField);

    return targetField;
}

void removeWidgets(PDField targetField) throws IOException {
    if (targetField instanceof PDTerminalField) {
        List<PDAnnotationWidget> widgets = ((PDTerminalField)targetField).getWidgets();
        for (PDAnnotationWidget widget : widgets) {
            PDPage page = widget.getPage();
            if (page != null) {
                List<PDAnnotation> annotations = page.getAnnotations();
                boolean removed = false;
                for (PDAnnotation annotation : annotations) {
                    if (annotation.getCOSObject().equals(widget.getCOSObject()))
                    {
                        removed = annotations.remove(annotation);
                        break;
                    }
                }
                if (!removed)
                    System.out.println("Inconsistent annotation definition: Page annotations do not include the target widget.");
            } else {
                System.out.println("Widget annotation does not have an associated page; cannot remove widget.");
                // TODO: In this case iterate all pages and try to find and remove widget in all of them
            }
        }
    } else if (targetField instanceof PDNonTerminalField) {
        List<PDField> childFields = ((PDNonTerminalField)targetField).getChildren();
        for (PDField field : childFields)
            removeWidgets(field);
    } else {
        System.out.println("Target field is neither terminal nor non-terminal; cannot remove widgets.");
    }
}