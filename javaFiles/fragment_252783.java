final TextField tf = new TextField();
    layout.addComponent(tf);
    tf.focus();
    tf.addBlurListener(new FieldEvents.BlurListener() {
        @Override
        public void blur(FieldEvents.BlurEvent event) {
            if (fieldShouldBeFocused)
                tf.focus();
        }
    });