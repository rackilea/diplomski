question.getSelectedBounds()
                .stream()
                .map(Shape::getBounds)
                .forEach(bounds -> {
                    SquareAnnotation squareAnnotation = (SquareAnnotation)
                            AnnotationFactory.buildAnnotation(
                                    pdfController.getPageTree().getLibrary(),
                                    Annotation.SUBTYPE_SQUARE,
                                    bounds);
                    squareAnnotation.setFillColor(true);
                    squareAnnotation.setFillColor(new Color(255, 250, 57, 120));
                    squareAnnotation.setRectangle(bounds);
                    squareAnnotation.setBBox(bounds);
                    squareAnnotation.resetAppearanceStream(null);
                    AbstractAnnotationComponent annotationComponent = AnnotationComponentFactory
                            .buildAnnotationComponent(squareAnnotation, pdfController.getDocumentViewController(),
                                    pageViewComponent, pdfController.getDocumentViewController().getDocumentViewModel());
                    pageViewComponent.addAnnotation(annotationComponent);
                });