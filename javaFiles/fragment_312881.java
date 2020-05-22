Graph graph = new SingleGraph("FreePlane");
System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
graph.display();
graph.setAttribute("stylesheet", "node { "
        + "     shape: rounded-box; "
        + "     padding: 5px; "
        + "     fill-color: white; "
        + "     stroke-mode: plain; "
        + "     size-mode: fit; "
        + "} "
        + "edge { "
        + "     shape: freeplane; "
        + "}");
graph.addAttribute("ui.quality");
graph.addAttribute("ui.antialias");

Node a = graph.addNode("A");
Node b = graph.addNode("B");
graph.addEdge("AB", "A", "B");
Node c = graph.addNode("C");
graph.addEdge("BC", "B", "C"); 

a.addAttribute("ui.label", "node A");
b.addAttribute("ui.label", "node B");
c.addAttribute("ui.label", "node C");