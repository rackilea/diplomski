@Override
    public void init()
    {
            double xFactor = ((double)(this.getWidth()))/((double)(qt.ORIGINAL_APPLET_WIDTH));
            double yFactor = ((double)(this.getHeight()))/((double)(qt.ORIGINAL_APPLET_HEIGHT));
            this.scalingTransform = new AffineTransform();
            this.inverseScalingTransform = new AffineTransform();
            this.scalingTransform.scale(xFactor,yFactor);
            this.inverseScalingTransform.scale(1D/xFactor,1D/yFactor);
            JPanel drawScale = new JPanel()
            {
                @Override
                public void paint(Graphics g)
                {
                    ((Graphics2D)g).setTransform(Test.this.scalingTransform);
                    super.paint(g);
                }
                @Override
                public void paintAll(Graphics g)
                {
                    ((Graphics2D)g).setTransform(Test.this.scalingTransform);
                    super.paintAll(g);
                }
                @Override
                public void paintComponents(Graphics g)
                {
                    ((Graphics2D)g).setTransform(Test.this.scalingTransform);
                    super.paintComponents(g);
                }
                @Override
                public void paintComponent(Graphics g)
                {
                    ((Graphics2D)g).setTransform(Test.this.scalingTransform);
                    super.paintComponents(g);
                }
            };
            Container oldPane = this.getContentPane();
            drawScale.setLayout(oldPane.getLayout());

            this.setContentPane(drawScale);
}