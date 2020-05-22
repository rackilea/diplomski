Set<String> retrieveAllLinksFromSite(int Level, Set<String> Links) {
    if (Level < 5) {
        Set<String> local_links =  new HashSet<String>();
        for (String link : Links) {
            // do download link
            Set<String> new_links = ;// do parsing the downloaded html of link;
            local_links.addAll(retrieveAllLinksFromSite(Level+1, new_links));
        }
        return local_links;
    } else {
        return Links;
    }

}