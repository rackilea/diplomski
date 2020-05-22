majorVersions
    .stream()
    .flatMap(mv -> mv.revisions())
    .filter(this::isNotParticularRevision)
    .flatMap(revision -> revision.roles())
    .map(role -> role.roleName()).collect(Collectors.toList());