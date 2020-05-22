private static class GUIAppWindow extends BasicWindow {
            GUIAppWindow() { 

                    Panel contentPanel = new Panel(new GridLayout(4)); 
                    GridLayout gridLayout = (GridLayout)contentPanel.getLayoutManager(); 
                    gridLayout.setHorizontalSpacing(3);

                    // Valid First Row ***************************************************** 
                    contentPanel.addComponent(new Label("AAAAA")); 
                    contentPanel.addComponent(new Label("BBBBB")); 
                    contentPanel.addComponent(new Label("DDDDD")); 
                    contentPanel.addComponent(new Label("EEEEE")); 

                    // Valid First Row ***************************************************** 
                    contentPanel.addComponent( 
                            new EmptySpace() 
                                    .setLayoutData( 
                                            GridLayout.createHorizontallyFilledLayoutData(3))); 
                    contentPanel.addComponent(new Label("HHHHH")); 

                    // Valid First Row ***************************************************** 
                    contentPanel.addComponent(new Label("HHHHH")); 
                    contentPanel.addComponent( 
                            new EmptySpace() 
                                    .setLayoutData( 
                                            GridLayout.createHorizontallyFilledLayoutData(2))); 
                    contentPanel.addComponent(new Label("IIIII")); 

                    // Valid First Row ***************************************************** 
                    contentPanel.addComponent(new Label("BBBBB")); 
                    contentPanel.addComponent(new Label("DDDDD")); 
                    contentPanel.addComponent(new Label("EEEEE")); 
                    contentPanel.addComponent(new Button("Exit", new Runnable() { 
                            @Override 
                            public void run() { 
                                    GUIAppWindow.this.close(); 
                            } 
                    })); 

                    // Invalid First Row ***************************************************** 
                    contentPanel.addComponent(new Label("KKKKK")); 
                    contentPanel.addComponent(new Label("LLLLL")); 
                    contentPanel.addComponent( 
                            new Button("Close", new Runnable() { 
                                    @Override 
                                    public void run() { 
                                            GUIAppWindow.this.close(); 
                                    } 
                    }), GridLayout.createHorizontallyEndAlignedLayoutData(2)); 

                    // Invalid First Row ***************************************************** 
                    contentPanel.addComponent( 
                            new EmptySpace() 
                                    .setLayoutData( 
                                            GridLayout.createHorizontallyFilledLayoutData(2))); 
                    contentPanel.addComponent(new Label("CCCCC"), GridLayout.createLayoutData( 
                            GridLayout.Alignment.CENTER, 
                            GridLayout.Alignment.BEGINNING, 
                            false, 
                            false, 
                            2, 
                            1)); 

                    // Invalid First Row ***************************************************** 
                    contentPanel.addComponent(new Label("FFFFF"), GridLayout.createLayoutData( 
                            GridLayout.Alignment.CENTER, 
                            GridLayout.Alignment.BEGINNING, 
                            true, 
                            false, 
                            4, 
                            1)); 

                    // Invalid First Row ***************************************************** 
                    contentPanel.addComponent(new Label("DDDDD")); 
                    contentPanel.addComponent(new Label("EEEEE")); 
                    contentPanel.addComponent(new Label("FFFFF"), GridLayout.createLayoutData( 
                            GridLayout.Alignment.CENTER, 
                            GridLayout.Alignment.BEGINNING, 
                            true, 
                            false, 
                            2, 
                            1)); 

                    this.setComponent(contentPanel); 
            } 
    }