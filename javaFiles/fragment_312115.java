y = x.stream()
            .map(X::getContentId)
            .distinct()
            .map(
                    contentId -> {
                        return reportModifier(reportViews, contentId);
                    }
            ).collect(Collectors.toList());


private Y reportModifier(List<x> x, String contentId) {
    Map<Date, Integer> contentList = x.stream()
                                .filter(a -> a.getContentId().equals(contentId))
                                .collect(
                                        Collectors.toMap(X::getReportDate, X::getCount)
                                );

                        X rv = x.stream()
                                .filter(a -> a.getContentId().equals(contentId))
                                .findFirst()
                                .get();

                        Y yy = new Y(rv, contentList);
                        return yy;

}