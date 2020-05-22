Runnable task = new Runnable() {
    @Override
    public void run () {
        try {
            … stuff to do goes here
        } catch ( Exception e ) {
            … Handle any unexpected exceptions bubbling up to avoid silently killing your executor service. 
        }
    }
}