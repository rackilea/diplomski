UIManager.getLookAndFeelDefaults().put("FileChooser.background", Constants.APP_BACKGROUND_COLOR);

UIManager.getLookAndFeelDefaults().put("FileChooser[Enabled].backgroundPainter",
                    new Painter<JFileChooser>()
                    {
                        @Override
                        public void paint(Graphics2D g, JFileChooser object, int width, int height)
                        {
                            g.setColor(Constants.APP_BACKGROUND_COLOR);
                            g.draw(object.getBounds());

                        }
                    });