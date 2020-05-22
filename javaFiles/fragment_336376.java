import java.io.*;

public class Foo {

    public static void traverseAndProcess( File startDir ) {
        for ( File f : startDir.listFiles() ) {
            // this file is a directory?
            if ( f.isDirectory() ) {
                // yes, it is, so we need to go inside this directory
                // calling the method again
                traverseAndProcess( f );
            } else {
                // no, it is not a directory
                // verifies if the file name finishes with ".xml"
                if ( f.getName().lastIndexOf( ".xml" ) != -1 ) {
                    // it is a xml (just verifying the extension)
                    // so, process this file!
                    process( f );
                }
            }
        }
    }

    private static void process( File f ) {
        // here you will process the xml
        System.out.println( "Processing " + f + " file..." );
    }

    public static void main( String[] args ) {
        // processing the current directory... change it
        traverseAndProcess( new File( "./" ) );
    }

}