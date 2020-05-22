mediaPlayerComponent = new EmbeddedMediaPlayerComponent() {

            @Override
            protected Window onGetOverlay() {
                final JWindow transparentWindow = new JWindow();

                // Set basic window opacity if required - the window system must support WindowTranslucency (i.e. PERPIXEL_TRANSLUCENT)!
                transparentWindow.setOpacity(0.8f);
                // White with transparent alpha channel - WindowTranslucency is required for translucency.
                transparentWindow.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));

                final JLabel superImposedLightweigtLabel = new JLabel("Hello, VLC.", JLabel.CENTER);
                superImposedLightweigtLabel.setOpaque(false);

                transparentWindow.getContentPane().add(superImposedLightweigtLabel);
                return transparentWindow;
            }
        ...
      }