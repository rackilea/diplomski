import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Iterator;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Test extends DefaultHandler {

        HashMap fieldnames = new HashMap();
        HashMap values = new HashMap();
        String tableName = "movie";
        Connection c = null;
        PreparedStatement ps = null;
        static final   String       sNEWLINE   = System.getProperty( "line.separator" );
        static private Writer       out        = null;
        private        StringBuffer textBuffer = null;
        int     numErrors = 0;
        long numInserts = 0;


        public void run(String [] args) {
                SAXParser saxParser;


                tableName = "about";
                String file = "C:\\insertxml.xml";


                try {
                        saxParser = SAXParserFactory.newInstance().newSAXParser();
                        long timePre = System.currentTimeMillis();
                        saxParser.parse( new File( file ), this );
                        long timeAfter = System.currentTimeMillis();
                        long timeTaken = (timeAfter - timePre)/1000;
                        long insertsPerSecond = numInserts/timeTaken; // <---- Error if timeTaken is zero
                        System.out.println("Errors: " + numErrors);
                        System.out.println("Inserts: " + numInserts);
                        System.out.println("Inserts per second: " + insertsPerSecond);
                        System.out.println("Seconds taken: " + (System.currentTimeMillis() - timePre)/1000);


                } catch (ParserConfigurationException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (SAXException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

        }

        public static void main(String [] args) {
                new Test().run(args);

        }

//      ---- SAX DefaultHandler methods ----

        public void startDocument()
        throws SAXException
        {
                //echoString( sNEWLINE + "<?xml ...?>" + sNEWLINE + sNEWLINE );
        }

        public void endDocument()
        throws SAXException
        {
                echoString( sNEWLINE );
        }

        public void startElement( String namespaceURI,
                        String localName,   // local name
                        String qName,       // qualified name
                        Attributes attrs )  throws SAXException {
                echoTextBuffer();
                String eName = ( "".equals( localName ) ) ? qName : localName;

                if(eName.equalsIgnoreCase("FIELD")) {
                        fieldnames.put(attrs.getValue("FieldName"), attrs.getValue("FieldType"));
                        System.out.println("Field:" + attrs.getValue("FieldName"));
                } else if(eName.equalsIgnoreCase("ROW")) {
                                // for each field prepare statement
                                Iterator itFields = fieldnames.keySet().iterator();
                                int fieldIdx = 1;
                                while(itFields.hasNext()) {
                                        String fieldName = itFields.next().toString();
                                        String type = fieldnames.get(fieldName).toString();
                                        String value = attrs.getValue(fieldName);

                                        if(type.equalsIgnoreCase("Integer")) {
                                            System.out.println(fieldIdx+" (integer) value:"+value);
                                        } else {
                                            System.out.println(fieldIdx+" (string) value:"+value);
                                        }
                                        fieldIdx++;
                                } // end while
                }

        }

        public void endElement( String namespaceURI,
                        String localName,     // local name
                        String qName )        // qualified name
        throws SAXException
        {

                String eName = ( "".equals( localName ) ) ? qName : localName;
                if(eName.equalsIgnoreCase("METADATA")) {
                        // build sql
                        StringBuffer buf = new StringBuffer();
                        for(int i = 0; i < fieldnames.size(); i++) {
                                buf.append("?");
                                if(i < (fieldnames.size()-1)) {
                                        buf.append(",");
                                }
                        }


//                        try {
//                                ps = c.prepareStatement("INSERT INTO " + tableName + " VALUES (" + buf.toString() + ")");
//                                System.out.println("INSERT INTO " + tableName + " VALUES (" + buf.toString() + ")");
//                        } catch (SQLException e) {
//                                // TODO Auto-generated catch block
//                                e.printStackTrace();
//                        }

                }


//              echoTextBuffer();

//              echoString( "</" + eName + ">" );           // element name
        }

        public void characters( char[] buf, int offset, int len )
        throws SAXException
        {
//              String s = new String( buf, offset, len );
//              if( textBuffer == null )
//              textBuffer = new StringBuffer( s );
//              else
//              textBuffer.append( s );
        }

        // ---- Helper methods ----

        // Display text accumulated in the character buffer
        private void echoTextBuffer()
        throws SAXException
        {
                if( textBuffer == null )  return;
                echoString( textBuffer.toString() );
                textBuffer = null;
        }

        // Wrap I/O exceptions in SAX exceptions, to
        // suit handler signature requirements
        private void echoString( String s )
        throws SAXException
        {
                try {
                        if( null == out )
                                out = new OutputStreamWriter( System.out, "UTF8" );
                        out.write( s );
                        out.flush();
                } catch( IOException ex ) {
                        throw new SAXException( "I/O error", ex );
                }
        }
}