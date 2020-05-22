GUIView1Controller controller1 = new GUIView1Controller();
    GUIView2Controller controller2 = new GUIView2Controller();

    // Add new instance GUI ; however , use the same instance of controller
    JSplitPane s = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,
                       new GUIView1(controller1), new GUIView2(controller2));

   JTabbedPane tabs = new JTabbedPane();
   tabs.addTab("First", new GUIView1(controller1));
   tabs.addTab("Second", new GUIView2(controller2));
   tabs.addTab("Both",  s );