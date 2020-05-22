import io.github.spencerpark.ijava.IJava;

IJava.getKernelInstance().getRenderer()
    .createRegistration(tech.tablesaw.plotly.components.Figure.class)
    .preferring(io.github.spencerpark.jupyter.kernel.display.mime.MIMEType.TEXT_HTML)
    .register((figure, ctx) -> {
        ctx.renderIfRequested(io.github.spencerpark.jupyter.kernel.display.mime.MIMEType.TEXT_HTML, () -> {
            String id = UUID.randomUUID().toString().replace("-", "");

            figure.asJavascript(id);
            Map<String, Object> context = figure.getContext();

            StringBuilder html = new StringBuilder();
            html.append("<div id=\"").append(id).append("\"></div>\n");
            html.append("<script>require(['https://cdn.plot.ly/plotly-1.44.4.min.js'], Plotly => {\n");
            html.append("var target_").append(id).append(" = document.getElementById('").append(id).append("');\n");
            html.append(context.get("figure")).append('\n');
            html.append(context.get("plotFunction")).append('\n');
            html.append("})</script>\n");
            return html.toString();
        });
    });