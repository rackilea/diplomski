private static AxisOptions getAxisOptions() {
    AxisOptions ao = AxisOptions.create();
    ao.set("viewWindowMode", "explicit");
    Options viewWindowOption = Options.create();
    viewWindowOption.set("max",max);
    ao.set("viewWindow",viewWindowOption);
    return ao;
}