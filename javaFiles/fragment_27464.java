// iterate over the fields in the required class. check if the annotatino is present
if (inputField.isAnnotationPresent(XmlElement.class)) {
    XmlElement xmlElementAnnotation = inputField.getAnnotation(XmlElement.class);

    // get 'required' value
    if(xmlElementAnnotation.required()) {
        // logic
    }
}