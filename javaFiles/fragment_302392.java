TokenEntry token = entityManager.find(TokenEntry.class, new TokenEntry.PK(processorName, segment), LockModeType.PESSIMISTIC_WRITE);
if (token == null) {
    token = new TokenEntry(processorName, segment, null, serializer);
    token.claim(nodeId, claimTimeout);
    entityManager.persist(token);
    // hibernate complains about updates in different transactions if this isn't flushed
    entityManager.flush();