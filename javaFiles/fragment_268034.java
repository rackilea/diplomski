function load(store)
{
var childs = Ext.clone(store.getRootNode().childNodes);
Ext.select('div#treepanel-1032-body div table tbody tr[class^="x-grid-row"]').remove();
treepanel.setRootNode({
 text: "Services",
 expanded: true,
 children: childs
});