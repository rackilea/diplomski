TypeElement java8AndBelowGeneratedAnnotation =
                pe.getElementUtils().getTypeElement( "javax.annotation.Generated" );
        if ( java8AndBelowGeneratedAnnotation != null ) {
            generatedAnnotation = java8AndBelowGeneratedAnnotation;
        }
        else {
            // Using the new name for this annotation in Java 9 and above
            generatedAnnotation = pe.getElementUtils().getTypeElement( "javax.annotation.processing.Generated" );
        }