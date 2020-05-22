Module m = ...
ModuleLayer layer = m.getLayer();
if (layer != null) {
    ModuleReference mref = layer.configuration()
            .findModule(m.getName())
            .map(ResolvedModule::reference)
            .orElseThrow(() -> new RuntimeException("should not happen"));
}