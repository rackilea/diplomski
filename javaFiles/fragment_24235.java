modelBatch = new ModelBatch(new DefaultShaderProvider() {
    @Override
    protected Shader createShader (Renderable renderable) {
        return new WarpShader(renderable);
    }
});