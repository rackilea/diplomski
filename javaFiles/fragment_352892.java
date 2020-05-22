private List<List<TypeMirror>> getNestedAnnotationClassesValue(Element element){

        List<List<TypeMirror>> classesInAnntation = new ArrayList<>();
        if (nonNull(element.getAnnotation(ParentAnnotation.class))) {
            List<? extends AnnotationMirror> annotations = element.getAnnotationMirrors();
            for (AnnotationMirror annotationMirror : annotations) {
                if (types.isSameType(annotationMirror.getAnnotationType(), elements.getTypeElement(ParentAnnotation.class.getName()).asType())) {
                    Map<? extends ExecutableElement, ? extends AnnotationValue> elementValues = annotationMirror.getElementValues();

                    elementValues.values()
                            .stream()
                            .findFirst()
                            .ifPresent(annotationValue -> {
                                List<AnnotationMirror> childAnnotations = (List<AnnotationMirror>) annotationValue.getValue();
                                childAnnotations.stream()
                                        .forEach(childAnnotationMirror -> {
                                            Collection<? extends AnnotationValue> values = childAnnotationMirror.getElementValues()
                                                    .values();
                                            AnnotationValue childAnnotationValue = values.stream().findFirst().get();
                                            List<AnnotationValue> classesInNestedAnnotation = (List<AnnotationValue>) childAnnotationValue.getValue();
                                            Iterator<? extends AnnotationValue> iterator = classesInNestedAnnotation.iterator();

                                            List<TypeMirror> typeMirrorsInNestedAnnotation = new ArrayList<>();

                                            while (iterator.hasNext()) {
                                                AnnotationValue next = iterator.next();
                                                typeMirrorsInNestedAnnotation.add((TypeMirror) next.getValue());
                                            }

                                            if (!typeMirrorsInNestedAnnotation.isEmpty()) {
                                                classesInAnntation.add(typeMirrorsInNestedAnnotation);
                                            }
                                        });
                            });
                }
            }
        }
        return classesInAnntation;
    }