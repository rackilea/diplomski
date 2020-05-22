else if (isVersionChanged(entity, source, persister, target)) {
    if (source.getFactory().getStatistics().isStatisticsEnabled()) {
        source.getFactory().getStatisticsImplementor()
            .optimisticFailure(entityName);
    }
    throw new StaleObjectStateException(entityName, id);
}