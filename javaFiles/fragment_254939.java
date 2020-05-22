cm = SVNClientManager.newInstance(new DefaultSVNOptions());
// Use do status to set deleted and added files information into SVN working copy management
cm.getStatusClient().doStatus(subVersionedDirectory, SVNRevision.HEAD, SVNDepth.INFINITY, false, false, false, false, new ISVNStatusHandler() {
            @Override
            public void handleStatus(SVNStatus status) throws SVNException {
                if (SVNStatusType.STATUS_UNVERSIONED.equals(status.getNodeStatus())) {
                    cm.getWCClient().doAdd(status.getFile(), true, false, false, SVNDepth.EMPTY, false, false);
                } else if (SVNStatusType.MISSING.equals(status.getNodeStatus())) {
                    cm.getWCClient().doDelete(status.getFile(), true, false, false);
                }
            }
        }, null);        
cm.getCommitClient().doCommit(new File[]{subVersionedDirectory}, false, "<commit> " + commitMessage, null, null, false, true, SVNDepth.INFINITY);