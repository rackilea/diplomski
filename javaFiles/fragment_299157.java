for(Element e : doc.getAllElements()){
        for(Node n: e.childNodes()){
            if(n instanceof Comment){
                System.out.println(n);
            }
        }
    }