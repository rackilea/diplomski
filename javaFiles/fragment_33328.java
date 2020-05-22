BooleanBuilder builder = new BooleanBuilder();
QContent content = QContent.content;
if (contentFilter.headlineFilter == null || contentFilter.headlineFilter.trim().length() == 0) {
        // no filtering on headline as headline filter = null or blank
    } else if (contentFilter.headlineFilter.equals(Filter.NULL_STRING)) {
        // special case when you want to filter for specific null headline
        builder.and(content.label.isNull());
    } else {
        try {
            long parseLong = Long.parseLong(contentFilter.headlineFilter);
            builder.and(content.id.eq(parseLong));
        } catch (NumberFormatException e) {
            builder.and(content.label.contains(contentFilter.headlineFilter));
        }
    }
    if (contentFilter.toDate != null) {
        builder.and(content.modifiedDate.loe(contentFilter.toDate));
    }
    if (contentFilter.fromDate != null) {
        builder.and(content.modifiedDate.goe(contentFilter.fromDate));
    }