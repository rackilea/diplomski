TabHost host = (TabHost) root.findViewById(R.id.tab_host);
    host.setup();

    TabSpec spec = host.newTabSpec("Tab One");
    spec.setContent(R.id.tab_one_container);
    spec.setIndicator("One");
    host.addTab(spec);

    spec = host.newTabSpec("Tab Two");
    spec.setContent(R.id.tab_two_container);
    spec.setIndicator("Two");
    host.addTab(spec);

    spec = host.newTabSpec("Tab Three");
    spec.setContent(R.id.tab_three_container);
    spec.setIndicator("Three");
    host.addTab(spec);


    host.setCurrentTab(0);