Collections.sort(mods, new Comparator<TextModification>() {
    @Override
    public int compare(TextModification mod1, TextModification mod2) {
        int pathComp = (mod2.getPath() + "z").compareTo(mod1.getPath() + "z");
        return pathComp == 0 ? mod2.getPriority() - mod1.getPriority() : pathComp;
    }
});