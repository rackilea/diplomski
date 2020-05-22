class LoggingPonyListener implements Listener<PonyEvent> {
    @Override
    public void process(PonyEvent event){
        System.out.println("Pony event occurred: " + event);
    }
}