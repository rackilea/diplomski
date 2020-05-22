import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.commonmark.Extension;
import org.commonmark.internal.renderer.NodeRendererMap;
import org.commonmark.internal.util.Escaping;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.Renderer;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.CoreHtmlNodeRenderer;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlNodeRendererFactory;
import org.commonmark.renderer.html.HtmlWriter;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommonMarkApp {

    public static void main(String[] args) throws Exception {
        File mdFile = new File("./resource/markdown.md").getAbsoluteFile();

        Parser parser = Parser.builder().build();
        Node document = parser.parseReader(new FileReader(mdFile));
        ObjectRenderer renderer = ObjectRenderer.builder().build();
        renderer.render(document);
        List<Object> nodes = renderer.getNodes();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println(mapper.writeValueAsString(nodes));
    }
}

class ObjectRenderer implements Renderer {

    private final String softbreak;
    private final boolean escapeHtml;
    private final boolean percentEncodeUrls;
    private final List<AttributeProviderFactory> attributeProviderFactories;
    private final List<HtmlNodeRendererFactory> nodeRendererFactories;
    private final ObjectWriter objectWriter = new ObjectWriter();

    private ObjectRenderer(Builder builder) {
        this.softbreak = builder.softbreak;
        this.escapeHtml = builder.escapeHtml;
        this.percentEncodeUrls = builder.percentEncodeUrls;
        this.attributeProviderFactories = new ArrayList<>(builder.attributeProviderFactories);

        this.nodeRendererFactories = new ArrayList<>(builder.nodeRendererFactories.size() + 1);
        this.nodeRendererFactories.addAll(builder.nodeRendererFactories);
        // Add as last. This means clients can override the rendering of core nodes if they want.
        this.nodeRendererFactories.add(new HtmlNodeRendererFactory() {
            @Override
            public NodeRenderer create(HtmlNodeRendererContext context) {
                return new CoreHtmlNodeRenderer(context);
            }
        });
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void render(Node node, Appendable output) {
        RendererContext context = new RendererContext(objectWriter);
        context.render(node);
    }

    @Override
    public String render(Node node) {
        render(node, null);
        return "Invoke getNodes()!";
    }

    public List<Object> getNodes() {
        return objectWriter.getNodes();
    }

    public static class Builder {

        private String softbreak = "\n";
        private boolean escapeHtml = true;
        private boolean percentEncodeUrls = true;
        private List<AttributeProviderFactory> attributeProviderFactories = new ArrayList<>();
        private List<HtmlNodeRendererFactory> nodeRendererFactories = new ArrayList<>();

        public ObjectRenderer build() {
            return new ObjectRenderer(this);
        }

        public Builder attributeProviderFactory(AttributeProviderFactory attributeProviderFactory) {
            this.attributeProviderFactories.add(attributeProviderFactory);
            return this;
        }

        public Builder nodeRendererFactory(HtmlNodeRendererFactory nodeRendererFactory) {
            this.nodeRendererFactories.add(nodeRendererFactory);
            return this;
        }

        public Builder extensions(Iterable<? extends Extension> extensions) {
            for (Extension extension : extensions) {
                if (extension instanceof ObjectRendererExtension) {
                    ObjectRendererExtension htmlRendererExtension = (ObjectRendererExtension) extension;
                    htmlRendererExtension.extend(this);
                }
            }
            return this;
        }
    }

    public interface ObjectRendererExtension extends Extension {
        void extend(Builder rendererBuilder);
    }

    private class RendererContext implements HtmlNodeRendererContext, AttributeProviderContext {

        private final HtmlWriter htmlWriter;
        private final List<AttributeProvider> attributeProviders;
        private final NodeRendererMap nodeRendererMap = new NodeRendererMap();

        private RendererContext(HtmlWriter htmlWriter) {
            this.htmlWriter = htmlWriter;

            attributeProviders = new ArrayList<>(attributeProviderFactories.size());
            for (AttributeProviderFactory attributeProviderFactory : attributeProviderFactories) {
                attributeProviders.add(attributeProviderFactory.create(this));
            }

            // The first node renderer for a node type "wins".
            for (int i = nodeRendererFactories.size() - 1; i >= 0; i--) {
                HtmlNodeRendererFactory nodeRendererFactory = nodeRendererFactories.get(i);
                NodeRenderer nodeRenderer = nodeRendererFactory.create(this);
                nodeRendererMap.add(nodeRenderer);
            }
        }

        @Override
        public boolean shouldEscapeHtml() {
            return escapeHtml;
        }

        @Override
        public String encodeUrl(String url) {
            if (percentEncodeUrls) {
                return Escaping.percentEncodeUrl(url);
            } else {
                return url;
            }
        }

        @Override
        public Map<String, String> extendAttributes(Node node, String tagName, Map<String, String> attributes) {
            Map<String, String> attrs = new LinkedHashMap<>(attributes);
            setCustomAttributes(node, tagName, attrs);
            return attrs;
        }

        @Override
        public HtmlWriter getWriter() {
            return htmlWriter;
        }

        @Override
        public String getSoftbreak() {
            return softbreak;
        }

        @Override
        public void render(Node node) {
            nodeRendererMap.render(node);
        }

        private void setCustomAttributes(Node node, String tagName, Map<String, String> attrs) {
            for (AttributeProvider attributeProvider : attributeProviders) {
                attributeProvider.setAttributes(node, tagName, attrs);
            }
        }
    }
}

class ObjectWriter extends HtmlWriter {

    private List<Object> nodes = new ArrayList<>();

    public ObjectWriter() {
        super(null);
    }

    @Override
    public void raw(String s) {
        nodes.add(Collections.singletonMap("raw", s));
    }

    @Override
    public void text(String text) {
        nodes.add(Collections.singletonMap("text", text));
    }

    @Override
    public void tag(String name) {
    }

    @Override
    public void tag(String name, Map<String, String> attrs) {
        nodes.add(Collections.singletonMap(name, attrs));
    }

    @Override
    public void tag(String name, Map<String, String> attrs, boolean voidElement) {
        tag(name, attrs);
    }

    @Override
    public void line() {
    }

    @Override
    protected void append(String s) {
        nodes.add(Collections.singletonMap("line", s));
    }

    public List<Object> getNodes() {
        return nodes;
    }
}