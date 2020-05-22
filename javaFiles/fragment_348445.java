rect.setOnScroll(new EventHandler<ScrollEvent>() {
        @Override public void handle(ScrollEvent event) {
            if (!event.isInertia()) {
                rect.setTranslateX(rect.getTranslateX() + event.getDeltaX());
                rect.setTranslateY(rect.getTranslateY() + event.getDeltaY());
            }
            log("Rectangle: Scroll event" +
                ", inertia: " + event.isInertia() + 
                ", direct: " + event.isDirect());
            event.consume();
        }
});

rect.setOnScrollStarted(new EventHandler<ScrollEvent>() {
        @Override public void handle(ScrollEvent event) {
            inc(rect);
            log("Rectangle: Scroll started event");
            event.consume();
        }
});

rect.setOnScrollFinished(new EventHandler<ScrollEvent>() {
        @Override public void handle(ScrollEvent event) {
            dec(rect);
            log("Rectangle: Scroll finished event");
            event.consume();
        }
});