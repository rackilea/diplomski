public class MyPhaseListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("afterPhase with ID : " + event.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        // Do not exceute subsequent phases if sending a redirect
        event.getFacesContext().responseComplete();
        try {
            ((HttpServletResponse)event.getFacesContext().getExternalContext().getResponse()).sendRedirect("http://stackoverflow.com");
        } catch (IOException ex) {
            Logger.getLogger(MyPhaseListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}