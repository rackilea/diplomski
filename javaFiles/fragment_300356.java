Composite videoComposite = new Composite(panel, 
                SWT.EMBEDDED | SWT.BORDER | SWT.NO_BACKGROUND);
        videoComposite.setLayout(new FillLayout());
        videoComposite.setLayoutData(new GridData(
                SWT.CENTER, SWT.CENTER, true, true, 1, 1));

        CLabel videoImage = new CLabel(videoComposite, SWT.SHADOW_IN);
        videoImage.setImage(dummyVideo);

        final Frame frame = SWT_AWT.new_Frame(videoComposite);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JApplet applet = new JApplet();
                applet.setFocusCycleRoot(false);
                applet.add(rabidPhoto.getVideoPanel(false));
                frame.add(applet);
                frame.pack();
                frame.setVisible(true);
            }
        });