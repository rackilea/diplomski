public static void main( String[] args ) throws Throwable {
   DocumentBuilderFactory dbf  = DocumentBuilderFactory.newInstance();
   dbf.setNamespaceAware( true );

   DocumentBuilder db = dbf.newDocumentBuilder();
   Document doc = db.newDocument();

   Element root = doc.createElement( "root" );
   root.setAttribute( "xmlns:m" , "http://www.lfinance.fr/blog-rachat-credits" );
   root.setAttribute( "xmlns:rt", "http://www.lfinance.fr/forum-rachat-credits" );
   doc.appendChild( root );

   Element elt = doc.createElement( "simple" );
   elt.setAttribute( "m:FC_TargetPath"   , "false" );
   elt.setAttribute( "m:FC_KeepInContent", "false" );
   elt.setAttribute( "rt:filterable"     , "false" );

   root.appendChild( doc.createTextNode( "\n\t" ));
   root.appendChild( elt );
   root.appendChild( doc.createTextNode( "\n" ));
   TransformerFactory.newInstance().newTransformer().transform(
      new DOMSource( doc ),
      new StreamResult( System.out ));
}