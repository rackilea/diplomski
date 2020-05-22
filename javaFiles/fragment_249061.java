String line = null;
    Pattern patternEdge = Pattern.compile("\\s*([A-Z])\\s*->\\s*([A-Z])\\s*\\[label=\"(\\d+),(\\d+)\"\\];");
    Pattern patternVertex = Pattern.compile("\\s*([A-Z])\\s*\\[label=\"([A-Z]),(\\d+)\"\\];");

    Matcher m = null;

    while ((line = in.readLine()) != null) {

                   m = patternEdge.matcher(line);

                  if (m.find()) {
                     String source = m.group(1);
                     String destination = m.group(2);
                     int speedLimit = Integer.parseInt(m.group(3));
                     int distance = Integer.parseInt(m.group(4));

                     Edges.add(new EdgesRep(source, destination, speedLimit, distance));
                  }
                  else {

                    m = patternVertex.matcher(line);

                    if (m.find()) {
                      String name = m.group(2);
                      int time = Integer.parseInt(m.group(3));

                      Vertex.add(new VerticesRep(name, time));
                    }
                    else
                      System.err.println("Expression is incorrect. No matches");

                  }
    }

    //for debugging
    for(EdgesRep e : Edges)
      System.out.println(e.getSource() + " " + e.getDestination() + " " + e.getSpeedLimit() + " " + e.getDistance());

    //for debugging
    for(VerticesRep v : Vertex)
      System.out.println(v.getName() + " " + v.getTime());