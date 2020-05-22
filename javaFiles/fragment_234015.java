public class KibanaExporter implements IExportTool<Kibana>{

    public void export(Kibana kibana) {
        kibana.toJSON();
    }
}