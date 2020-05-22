void writeHeader() throws IOException {
    if (layout != null && (outputStream != null)) {
        StringBuilder sb = new StringBuilder();
        appendIfNotNull(sb, layout.getFileHeader());
        appendIfNotNull(sb, layout.getPresentationHeader());
        if (sb.length() > 0) {
            sb.append(CoreConstants.LINE_SEPARATOR);

            // replace a couple of header names with shorter and smaller text            
            String outString = sb.toString();
            outString = outString.replaceAll( "MethodOfCaller", "MoC" ).replaceAll( "RelativeTime", "RT" );
            outString = outString.replaceAll( "LineOfCaller", "LoC" );
            // make text smaller
            outString = outString.replaceAll( "<td class=(.+?)>", "<td style=\"font-size:13px\" class=$1>" );

            outputStream.write(convertToBytes( outString ));
            outputStream.flush();
        }
    }
}