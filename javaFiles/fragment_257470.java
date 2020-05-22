CriteriaQuery<News> cq = cb.createQuery(News.class);
    Root<News> news = cq.from(News.class);
    cq = cq.select(news).distinct(true);

    if (sc != null) {
        boolean authorExist = sc.getAuthorId() != null;
        boolean tagsExist = sc.getTagIdsSet() != null && !sc.getTagIdsSet().isEmpty();

        if (authorExist && !tagsExist) {
            cq.where(cb.in(news.get("author").get("id")).value(sc.getAuthorId()));
        } else if (!authorExist && tagsExist) {
            cq.where(cb.or(addTags(cb, news, sc)));
        } else {
            cq.where(cb.and(
                    cb.in(news.get("author").get("id")).value(sc.getAuthorId()),
                    cb.or(addTags(cb, news, sc))
            ));
        }
    }

    return cq.orderBy(cb.desc(cb.size(news.<Collection>get("commentsList"))),
            cb.desc(news.get("modificationDate")));