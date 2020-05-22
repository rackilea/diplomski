public class EtdDokumentRowPanel extends Panel
{
    ...
    public EtdDokumentRowPanel ( String id, EtdDokument doc, final RepeatingView view )
    {
        //your panel should have markup id:
        setOutputMarkupId ( true );
        ...
        AjaxLink<Void> deleteLink = new AjaxLink<Void> ( "deleteLink" )
        {    
            @Override
            public void onClick ( AjaxRequestTarget target )
            {
                EtdDokumentRowPanel thisPanel = EtdDokumentRowPanel.this;

                // removing row panel from RepeatingView:
                view.remove (thisPanel);

                // execute this js to remove child from Wicket parent component:
                target.prependJavascript ( 
                        "Wicket.$('" + view.getParent ().getMarkupId () + "')" +
                        ".removeChild(Wicket.$('" + thisPanel.getMarkupId () +
                        "'));" );    
            }
        };
        add ( deleteLink );
        ...
    }
}