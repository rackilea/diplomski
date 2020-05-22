// UI

final JFrame frame = new JFrame();
frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

// Metawidget

final SwingMetawidget metawidget = new SwingMetawidget();
...configure Metawidget by setting inspectors, inspection result processors, widget builders, etc...
metawidget.setToInspect( myData );
frame.add( metawidget, BorderLayout.CENTER );