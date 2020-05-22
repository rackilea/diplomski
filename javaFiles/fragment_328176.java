class demo {
    public static void main( String str[] ) throws Exception {
        Process p = Runtime.getRuntime().exec( "wget -P C:\\vignesh\\Docx\\docx_final\\Html2Docx\\src http://anbu/upload/ExportHtml.html"" );
        p.waitFor();
        // do more processing
    }
}