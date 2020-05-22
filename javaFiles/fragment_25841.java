document = PDDocument.load( args[0] );
if( document.isEncrypted() )
{
    System.err.println( "Error: Cannot add bookmarks to encrypted document." );
    System.exit( 1 );
}
PDDocumentOutline outline =  new PDDocumentOutline();
document.getDocumentCatalog().setDocumentOutline( outline );
PDOutlineItem pagesOutline = new PDOutlineItem();
pagesOutline.setTitle( "All Pages" );
outline.appendChild( pagesOutline );
List pages = document.getDocumentCatalog().getAllPages();
for( int i=0; i<pages.size(); i++ )
{
    PDPage page = (PDPage)pages.get( i );
    PDPageFitWidthDestination dest = new PDPageFitWidthDestination();
    dest.setPage( page );
    PDOutlineItem bookmark = new PDOutlineItem();
    bookmark.setDestination( dest );
    bookmark.setTitle( "Page " + (i+1) );
    pagesOutline.appendChild( bookmark );
}
pagesOutline.openNode();
outline.openNode();

document.save( args[1] );