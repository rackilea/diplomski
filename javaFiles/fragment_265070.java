public static class JSONDecoder extends ByteToMessageDecoder {

    // Notice, this class is designed for JSON without a charset definition at the start, adding this is hard as we basicly have to call differend
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        in.markReaderIndex();

        int fromIndex = in.readerIndex();

        int unclosedCurlyBracketsSeen = 0;
        boolean inQuotedSection = false;
        boolean nonWhitespaceSeen = false;
        boolean slashSeen = false;

        while (in.isReadable()) {
            boolean newSlashSeenState = false;
            byte character = in.readByte();
            if (character == '{' && !inQuotedSection) {
                unclosedCurlyBracketsSeen++;
            }
            if (character == '}' && !inQuotedSection) {
                unclosedCurlyBracketsSeen--;
            }
            if (character == '[' && !inQuotedSection) {
                unclosedCurlyBracketsSeen++;
            }
            if (character == ']' && !inQuotedSection) {
                unclosedCurlyBracketsSeen--;
            }
            if (character == '"' && !slashSeen) {
                inQuotedSection = !inQuotedSection;
            }
            if (character == '\\' && !slashSeen) {
                newSlashSeenState = true;
            }
            if (!Character.isWhitespace(character)) {
                nonWhitespaceSeen = true;
            }
            slashSeen = newSlashSeenState;
            if(unclosedCurlyBracketsSeen == 0 && nonWhitespaceSeen) {
                int targetIndex = in.readerIndex();
                out.add(in.slice(fromIndex, targetIndex - fromIndex).retain());
                return;
            }
        }

        // End of stream reached, but our JSON is not complete, reset our progress!
        in.resetReaderIndex();
    }

}