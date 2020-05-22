public void resultChanged(LookupEvent ev) {
    for(ShowAuditEventsCapability capability : lkpInfo.allInstances()) {
        if(!capability.isEnabled()) {
            setEnabled(false);
            return;
        }
    }
    setEnabled(true);
}