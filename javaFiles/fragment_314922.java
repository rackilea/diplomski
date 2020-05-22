@Grab( 'net.sourceforge.htmlcleaner:htmlcleaner:2.2' )
@Grab( 'commons-lang:commons-lang:2.6' )
import org.apache.commons.lang.StringEscapeUtils
import org.htmlcleaner.*

String location = 'http://www.nytimes.com/2011/08/14/arts/music/jay-z-and-kanye-wests-watch-the-throne.html'
String cookie = null
String pageContent = ''

while( location ) {
  new URL( location ).openConnection().with { con ->
    // We'll do redirects ourselves
    con.instanceFollowRedirects = false

    // If we got a cookie last time round, then add it to our request
    if( cookie ) con.setRequestProperty( 'Cookie', cookie )
    con.connect()

    // Get the response code, and the location to jump to (in case of a redirect)
    int responseCode = con.responseCode
    location = con.getHeaderField( "Location" )

    // Try and get a cookie the site will set, we will pass this next time round
    cookie = con.getHeaderField( "Set-Cookie" )

    // Read the HTML and close the inputstream
    pageContent = con.inputStream.withReader { it.text }
  }
}

// Then, clean paceContent and get the title
HtmlCleaner cleaner = new HtmlCleaner()
CleanerProperties props = cleaner.getProperties()

TagNode node = cleaner.clean( pageContent )
TagNode titleNode = node.findElementByName("title", true);

def title = titleNode.text.toString()
title = StringEscapeUtils.unescapeHtml( title ).trim()
title = title.replace( "\n", "" )

println title