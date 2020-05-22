public List<AuditEntry> getAllAuditEntries()
    {
        if (!isViewed)
        {
            isViewed = true;
            auditFacade.createAuditEntry(
                __creates Audit Entry here__);
        }

        return allAuditEntries;
    }