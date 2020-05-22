vv.getRenderContext().setVertexShapeTransformer(new Transformer<String, Shape>()
    {
        @Override
        public Shape transform(String vertex)
        {
            return new Rectangle2D.Double(-10,-10,40,20);
        }
    });

    BasicVertexLabelRenderer<String, Integer> vertexLabelRenderer = 
        new BasicVertexLabelRenderer<String, Integer>();
    vertexLabelRenderer.setPosition( Renderer.VertexLabel.Position.CNTR);
    vv.getRenderer().setVertexLabelRenderer(vertexLabelRenderer);