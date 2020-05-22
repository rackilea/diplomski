for (int i = 0; i < library_visual_scenes.getLength(); i++) {
   Element element = (Element) nodes.item(i);
   Node visual_scene = element.getFirstChild();
   if(visual_scene.getNodeType() == Node.ELEMENT_NODE)
   {
      String id = ((Element)visual_scene).getAttribute(id);
      System.out.println("id="+id);
    }
 }