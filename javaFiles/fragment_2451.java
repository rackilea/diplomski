NodeList triangles = document.getElementsByTagName("triangles");
    System.out.println("triangles: " + triangles.getLength());

    for (int i = 0; i < triangles.getLength(); i++) {
        Element triangle = (Element) triangles.item(i);
        System.out.println("triangle: material=" + triangle.getAttribute("material") + " count=" + triangle.getAttribute("count"));

        NodeList inputs = triangle.getElementsByTagName("input");
        for (int j = 0; j < triangles.getLength(); j++) {
            Element input = (Element) inputs.item(j);
            System.out.println("  input: semantic=" + input.getAttribute("semantic"));
        }

        Element vertices = (Element) triangle.getElementsByTagName("p").item(0);
        System.out.println("  vertices: " + vertices.getTextContent().trim());
    }