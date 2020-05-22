private void addClickListener() {
    this.addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            wasTouched(); // Call a function in the Ball/Image object.
        }
    });
}