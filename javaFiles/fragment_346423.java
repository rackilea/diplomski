AnnotationDescriptor<Length> descriptor = new AnnotationDescriptor<Length>( Length.class );
  descriptor.setValue( "min", 0 );
  descriptor.setValue( "max", 10 );
  ...

  Length lengthAnnotation = AnnotationFactory.create( descriptor );