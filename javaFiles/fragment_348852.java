public boolean equals(EventSnapshot es) {
    // TODO: Decide how to handle the situation where es itself is null
    if (content == es.getContent()) {
        return true;
    }
    if (content == null || es.getContent() == null) {
        return false;
    }
    return content.equals(es.getContent());
}