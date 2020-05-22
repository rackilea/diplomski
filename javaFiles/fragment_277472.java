public class CustomFreeMarkerView extends FreeMarkerView {

    @Override
    protected void processTemplate(Template template, SimpleHash model, HttpServletResponse response) throws IOException, TemplateException {
        StringWriter writer = new StringWriter();
        template.process(model, writer);
        String formattedTemplate = formatTemplate(writer.toString());
        response.getWriter().write(formattedTemplate);

    }

    private String formatTemplate(String renderedTemplate) {
        //do custom formatting of the renderedTemplate here
        return renderedTemplate;
    }
}