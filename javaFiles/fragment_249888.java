/* Method, which init your form */
private void init()
{
    /* Container, which will hold all FileUploadFields,
       as RepeatingView adds children to it's parent object. */
    WebMarkupContainer container = new WebMarkupContainer("container");

    /* We need DOM id for container component. */
    container.setOutputMarkupId(true);
    add(container);

    final RepeatingView rv = new RepeatingView("dokumenteList");
    container.add (rv);

    /* We need to add all default model values by ourselfs for RepeatingView: */
    for(EtdDokument doc : getListModel().getObject())
    {
        createDocumentRow(rv, doc);
    }

    final AjaxLink<String> addLink = new AjaxLink<String>("addDokument") {
        @Override
        public void onClick(AjaxRequestTarget target) {
            final EtdDokument newValue...;
            final EtdDokumentRowPanel r = createDocumentRow(rv, newValue);

            ...

            /* This is it. We dynamicly adding created earlier component to markup.
               This allows us to update this component via ajax. */
            target.prependJavaScript(
                    "var item=document.createElement('div');" + //creating empty 'div' tag
                    "item.id='" + r.getMarkupId() + "'; " + // set markup id for this 'div'.
                    "Wicket.$('" + container.getMarkupId() + "').appendChild(item);" // add this 'div' as container child.
            );

            /* Added 'div' is still empty, but this update will replace
               it, by real component's markup.*/
            target.add(r);
        }
    };
    add(addLink);
}

/* This method creates new instance of EDRowP (with random id) and adds
   it to RepeatingView. 
   I have dropped the implementation of your headRow, but you can include it 
   into the EDRowPanel or implement something similar. 
*/
private EtdDokumentRowPanel createDocumentRow( RepeatingView rv, EtdDokument doc )
{
    EtdDokumentRowPanel row = new EtdDokumentRowPanel(rv.newChildId(), doc);
    rv.add(row);
    return row;
}