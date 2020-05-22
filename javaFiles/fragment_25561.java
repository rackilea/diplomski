enum Component {
    ELECTRON, PROTON, NEUTRON;
}

interface GenericParticle {
    List<String> getNames();

    List<Component> getComponents();
}

enum BasicGenericParticle implements GenericParticle {
    ELECTRON(
            Arrays.asList("electron", "e"),
            Arrays.asList(Component.ELECTRON)
    ),
    HYDROGEN(
            Arrays.asList("hydrogen", "h"),
            Arrays.asList(Component.ELECTRON, Component.PROTON)
    )
    ;

    private final List<String> names;
    private final List<Component> components;

    private BasicGenericParticle(final List<String> names, final List<Component> components) {
        this.names = names;
        this.components = components;
    }

    @Override
    public List<String> getNames() {
        return new ArrayList<>(names);
    }

    @Override
    public List<Component> getComponents() {
        return new ArrayList<>(components);
    }
}

class GenericParticleBuilder {
    private List<String> names = new ArrayList<>();
    private List<Component> components = new ArrayList<>();

    public GenericParticleBuilder name(final String name) {
        names.add(name);
        return this;
    }

    public GenericParticleBuilder component(final Component component) {
        components.add(component);
        return this;
    }

    public GenericParticle build() {
        return new GenericParticleImpl(names, components);
    }

    private static class GenericParticleImpl implements GenericParticle {
        private List<String> names = new ArrayList<>();
        private List<Component> components = new ArrayList<>();

        public GenericParticleImpl(final List<String> names, final List<Component> components) {
            this.names = names;
            this.components = components;
        }

        @Override
        public List<String> getNames() {
            return new ArrayList<>(names);
        }

        @Override
        public List<Component> getComponents() {
            return new ArrayList<>(components);
        }
    }
}