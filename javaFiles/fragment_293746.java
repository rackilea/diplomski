@Inject
Environment environment;

@Property
private DialogConfigs dialogConfigs;

@Property
private DialogConfig dialogConfig;

void beforeRender() {
    dialogConfigs = new DialogConfigsImpl();
    environment.push(DialogConfigs.class, dialogConfigs);
}

void afterRender() {
    environment.pop(DialogConfigs.class);
}