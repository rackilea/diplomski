XMLConfiguration conf1 = new XMLConfiguration("table1.xml");
    XMLConfiguration conf2 = new XMLConfiguration("table2.xml");

    // Create and initialize the node combiner
    NodeCombiner combiner = new UnionCombiner();
    combiner.addListNode("table");  // mark table as list node
                // this is needed only if there are ambiguities

    // Construct the combined configuration
    CombinedConfiguration cc = new CombinedConfiguration(combiner);
    cc.addConfiguration(conf1, "tab1");
    cc.addConfiguration(conf2);

    PropertiesConfiguration config = new PropertiesConfiguration("usergui.properties");

    config.copy(cc);
    config.save();