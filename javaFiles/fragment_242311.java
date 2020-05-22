String path = "c:\\test.csv";
            Charset encoding = Charset.forName("ISO-8859-1");
            try {
                List<String> lines = Files.readAllLines(Paths.get(path), encoding);
                Graph graph = new RexsterGraph("http://190.188.20.11:8183/graphs/graph");

                for (String line : lines) {
                    Vertex currentNode = graph.addVertex(null);
                    String[] values = line.split(",");
                    for (String value : values) {
                        String[] property = value.split(":");
                        currentNode.setProperty(property[0].toString(), property[1].toString());
                    }
                }

            }