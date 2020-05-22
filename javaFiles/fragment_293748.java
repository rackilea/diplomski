@Environmental
private DialogConfigs dialogConfigs;

@Parameter
private String foo;

@Parameter
private String bar;

void beforeRender() {
    dialogConfigs.add(new DialogConfig(foo, bar));
}