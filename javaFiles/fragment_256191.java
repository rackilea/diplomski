fetch();

// todo: isn't there a critical section here? Only within the same repo maybe. We could prevent simultaneous use of the same racfid.
Ref fetchHead;
try {
    fetchHead = m_git.getRepository().findRef("FETCH_HEAD");

    //todo: show the diff bewteen fetch-head and the current head.
    // - get object id of fetch
    // - get oid of head

    ObjectId head = m_git.getRepository().resolve(Constants.HEAD);

    AbstractTreeIterator oldTreeParser = prepareTreeParser(m_git.getRepository(), fetchHead.getObjectId());
    AbstractTreeIterator newTreeParser = prepareTreeParser(m_git.getRepository(), head);

    List<DiffEntry> diff = m_git.diff().
        setOldTree(oldTreeParser).
        setNewTree(newTreeParser).
        // setPathFilter(PathFilter.create("README.md")).
        // to filter on Suffix use the following instead
        //setPathFilter(PathSuffixFilter.create(".java")).
        call();

    for (DiffEntry entry : diff) {
        System.out.println("Entry: " + entry + ", from: " + entry.getOldId() + ", to: " + entry.getNewId());
    }