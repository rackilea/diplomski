public void removeChilds(Element root, String h3Text)
{
    final Element h3Start = root.select("h3:contains(" + h3Text + ")").first();
    final int h3Idx = h3Start.siblingIndex();

    for( Element e : h3Start.siblingElements() )
    {
        // Skip all nodes before the relevant h3 element
        if( e.siblingIndex() > h3Idx )
        {
            switch(e.tagName())
            {
                case "p":
                    e.remove();
                    break;
                case "h3":
                    /* Stop if there's a h3 */
                    return;
                default:
                    /* Stop also if there's any non-p element!? */
                    return;
            }
        }
    }
}