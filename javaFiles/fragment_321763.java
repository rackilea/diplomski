splash_window.addWindowListener(new WindowListener() {

        @Override
        public void windowOpened(WindowEvent e) {
            initProgress.setValue(getProgress(5));
            initProgress.revalidate();
        }

        ...

    });