private List<ContentLinkMetadata> getAndFillInternalLinks(final Lesson lesson) {
    List<ContentLinkMetadata> internalLinks = new ArrayList<>();
        lesson.getAssetLinks().stream()
        .filter(linkAsAssetLink -> ALLOWED_INTERNAL_LINK_TYPES.contains(linkAsAssetLink.getTargetType()))
        .map(linkAsAssetLink -> {
            Content link = contentProvider.getLazyById(linkAsAssetLink.getTargetId());
            ContentLinkMetadata internalLink = new ContentLinkMetadata();

            internalLink.setDescription(link.getDescription());
            internalLink.setId(link.getId());
            internalLink.setTitle(link.getTitle());
            internalLink.setFriendlyUrl(friendlyUrlResolver.makeUrl(link));
            internalLink.setTypeId(link.getTypeId());

            return internalLink;
        }).foreach(internalLinks::add);

        return internalLinks;
}