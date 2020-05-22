pane.addHyperlinkListener(new HyperlinkListener()
{
    public void hyperlinkUpdate(HyperlinkEvent r){
        try{
            if(r.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
            pane.setPage(r.getURL());
        }
        catch(Exception e){
        }
    }
 });