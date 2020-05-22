public boolean canFinish() {
    // Default implementation is to check if all pages are complete.
    for (int i = 0; i < pages.size(); i++) {
        if (!pages.get(i).isPageComplete()) {
            return false;
        }
    }
    return true;
}