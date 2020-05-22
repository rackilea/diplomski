public boolean isLinkedTo(Link to) {
    // start recursion with no currently checked links
    return isLinkedTo(to, new HashSet<>());
}

private boolean isLinkedTo(Link to, Set<Link> linksChecked) {
    // this link is linked to 'to'
    if (links.contains(to)) {
        return true;
    }
    // this link not linked to 'to' so add it to the checked links
    linksChecked.add(this);
    // check all links to see if the links are linked to 'to'
    for (Link link: links) {
        // current link not checked yet and current link is linked to 'to'
        if (!linksChecked.contains(link) && link.isLinkedTo(to, linksChecked)) {
            return true;
        }
    }
    // no links or sub-links are linked to 'to'
    return false;
}