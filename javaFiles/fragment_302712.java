Collection<Ref> refs = Git.lsRemoteRepository()
            .setHeads(true)
            .setRemote(REMOTE_URL)
            .call();

    for (Ref ref : refs) {
        System.out.println("Ref: " + ref);
    }