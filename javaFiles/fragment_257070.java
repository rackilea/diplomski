// get the pages from the registry
    PreferencePageRegistryReader registryReader = new PreferencePageRegistryReader(PlatformUI.getWorkbench());
    registryReader.loadFromRegistry(Platform.getExtensionRegistry());

    // we get the unfiltered list of pages
    Field topLevelNodes = CategorizedPageRegistryReader.class.getDeclaredField("topLevelNodes"); //$NON-NLS-1$
    topLevelNodes.setAccessible(true);
    Collection<?> pageContributions = (Collection<?>) topLevelNodes.get(registryReader);
    topLevelNodes.setAccessible(false);

    // we remove the ones already displayed
    Set<String> alreadyDisplayedIds = (Set<String>) registryReader.getTopLevelNodes().stream()
            .filter(o -> o instanceof WorkbenchPreferenceNode).map(n -> ((WorkbenchPreferenceNode) n).getId())
            .collect(Collectors.toSet());
    for (Iterator<?> iterator = pageContributions.iterator(); iterator.hasNext();) {
        Object object = iterator.next();
        if (object instanceof WorkbenchPreferenceNode
                && alreadyDisplayedIds.contains(((WorkbenchPreferenceNode) object).getId())) {
            iterator.remove();
        }
    }

    // now we add the currently invisible pages
    ((WorkbenchPreferenceManager) PlatformUI.getWorkbench().getPreferenceManager()).addPages(pageContributions);