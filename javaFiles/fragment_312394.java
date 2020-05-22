Point myPoint = new Point(x, y);
      Point myNextPoint = new Point(xToFillNext, yToFillNext);

      directedGraph.addVertex(myPoint);
      directedGraph.addVertex(myNextPoint);
      directedGraph.addEdge(myPoint, myNextPoint);