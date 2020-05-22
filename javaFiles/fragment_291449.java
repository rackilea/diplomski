public class DecoratedLayer implements Layer {
    private final Layer _layer;
    private final I_LayerDecorator _decorator;

    public DecoratedLayer(Layer layer, I_LayerDecorator decorator) {
        _layer = layer;
        _decorator = decorator;
    }

    @Override
    public void preRender(DrawContext dc) {
       _decorator.preRender(dc, _layer);
    }

    @Override
    public void render(DrawContext dc) {
       _decorator.render(dc, _layer);
    }

    // all other methods delegate to _layer
}

public class ShadingDecorator implements I_LayerDecorator {
    private GLSL glsl;
    private final File vertfile;
    private final File fragfile;

    public ShadingDecorator(final File vertexShaderFile, 
                            final File fragmentShaderFile) {
        vertfile = vertexShaderFile;
        fragfile = fragmentShaderFile;
    }

    @Override
    public void preRender(DrawContext dc, Layer layer) {
        if (glsl == null) {
            glsl = new GLSL(dc.getGL());
            glsl.loadVertexShader(vertfile);
            glsl.loadFragmentShader(fragfile);
        }
        layer.preRender(dc);
    }

    @Override
    public void render(DrawContext dc, Layer layer) {
        if (glsl != null) {
            glsl.useShaders();
            glsl.startShader();
            GL gl = dc.getGL();
            gl.glUniform1i(glsl.getUniformLocation("tile_image"), 0);

            layer.render(dc);

            glsl.endShader();
        }
    }
}