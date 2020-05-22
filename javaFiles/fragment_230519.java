pane.addHyperlinkListener(new HyperlinkListener()
{
    public void hyperlinkUpdate(HyperlinkEvent r){
        try{
            if(r.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
            Desktop.getDesktop().browse(new URI(r.getURL().toURI()));
        }
        catch(Exception e){
        }
    }
 });