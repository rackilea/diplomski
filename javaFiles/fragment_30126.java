public StatusBar extends JLabel {
    public StatusBar() {
        AnnotationProcessor.process(this);
    }
    @EventSubscriber(eventClass=StatusEvent.class)
    public void updateStatus(StatusEvent statusEvent) {
        this.setText(statusEvent.getStatusText();
    }
}