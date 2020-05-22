String getText(Element parentElement) {
     String working = "";
     for (Node child : parentElement.childNodes()) {
          if (child instanceof TextNode) {
              working += child.text();
          }
          if (child instanceof Element) {
              Element childElement = (Element)child;
              // do more of these for p or other tags you want a new line for
              if (childElement.tag().getName().equalsIgnoreCase("br")) {
                   working += "\n";
              }                  
              working += getText(childElement);
          }
     }

     return working;
 }