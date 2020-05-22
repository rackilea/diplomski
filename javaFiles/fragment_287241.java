// we save the current perspective
    IPerspectiveDescriptor currentPerspective = page.getPerspective();
    if (currentPerspective != null) {
        // E4 sometimes lacks perspective
        page.savePerspectiveAs(currentPerspective);
    }

    // switch to the default one (should never have views)
    String defaultPerspectiveId = PlatformUI.getWorkbench().getPerspectiveRegistry().getDefaultPerspective();
    final IPerspectiveDescriptor defaultPerspective = registry.findPerspectiveWithId(defaultPerspectiveId);
    page.setPerspective(defaultPerspective);

    // clone it
    IPerspectiveDescriptor clone = ((PerspectiveRegistry) registry).createPerspective(String.valueOf(this.nextId++),
            (PerspectiveDescriptor) defaultPerspective);
    page.savePerspectiveAs(clone);