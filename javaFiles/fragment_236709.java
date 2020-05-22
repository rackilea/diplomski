private void setupAnnotations() {

            // Create an AnnotationLayer with lots of annotations
            this.layer = new AnnotationLayer();

            GlobeAnnotation ga = new GlobeAnnotation("Annotation", Position.fromDegrees(20, -100.9, 1000));
            ga.getAttributes().setTextColor(Color.white);
            ga.getAttributes().setBackgroundColor(Color.BLACK);
            ga.getAttributes().setOpacity(.75f);
            **ga.setAlwaysOnTop(true);**
            layer.addAnnotation(ga);

            ga = new GlobeAnnotation("Annotation", Position.fromDegrees(25, -100.9, 1000));
            ga.getAttributes().setTextColor(Color.white);
            ga.getAttributes().setBackgroundColor(Color.BLACK);
            ga.getAttributes().setOpacity(.75f);
            **ga.setAlwaysOnTop(true);**
            layer.addAnnotation(ga);

            // Add layer to the layer list and update the layer panel
            insertBeforeCompass(this.getWwd(), layer);
        }