public MPerspective getActivePerspective(MWindow window) {
    List<MPerspectiveStack> pStacks = findElements(window, null, MPerspectiveStack.class);
    if (pStacks.size() == 1) {
        MPerspective perspective = pStacks.get(0).getSelectedElement();
        return perspective;
    }

    return null;
}