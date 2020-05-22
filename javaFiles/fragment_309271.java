Thread th = new Thread(new Runnable()
    {

        @Override
        public void run()
        {
            Display.getDefault().syncExec(new Runnable()
            {
                @Override
                public void run()
                {
                    Display display = Display.getDefault();
                    Shell shell = new Shell(display);
                    FileDialog dialog=new FileDialog(shell);
                    dialog.setText("Enter a filename");
                    dialog.setFilterPath("c:\\");
                    String selected=dialog.open();
                    log.error(selected);
                    while (!shell.isDisposed())
                    {
                        if (!display.readAndDispatch())
                            display.sleep();
                    }

                }

            });
        }
    });

    th.start();