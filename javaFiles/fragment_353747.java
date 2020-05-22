jSVGCanvas1.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter() {
        public void documentLoadingCompleted(SVGDocumentLoaderEvent e) {
          SVGDocument doc = jSVGCanvas1.getSVGDocument();
          if(doc==null)System.out.println("null");
        }
    });