Collection< PublicationSession > wantedPublications = 
    effectiveDatePublicationMap.values() // Collection<List<PublicationSession>>
                               .stream() // Stream<List<PublicationSession>>
                               .flatMap(list->list.stream()) // Stream<PublicationSession>
                               .filter(pub -> PublicationStatus.valueOf(pub.getPublishStatus()) == PublicationStatus.COMPLETE)
                               .sorted(Comparator.comparing(PublicationSession::getCreateTime))
                               .collect(toMap(p -> p.getPublicationSession().getEffDateTime(), UnaryOperator.identity(), PICK_LATEST))
                               .values();