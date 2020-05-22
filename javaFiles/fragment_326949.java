public static Font getStrikethroughFont2(String name, int properties, int size)
{
   Font font = new Font(name, properties, size); 
   Map<TextAttribute, Object>  attributes = new HashMap<TextAttribute, Object>();
   attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON); 
   Font newFont = font.deriveFont(attributes);
   return newFont;             
}