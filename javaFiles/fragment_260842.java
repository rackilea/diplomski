LinearGradientPaint lgp = new LinearGradientPaint(
                new Point2D.Float(0, minY),
                new Point2D.Float(0, maxY),
                new float[] {0f, 0.5f, 1f},
                new Color[] {Color.BLUE, Color.RED, Color.BLUE}
                );
g2d.setPaint(lgp);
    // Render all your samples, don't reapply or change you paint...