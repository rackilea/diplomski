//Extract Tags
private List<String> readHtml(XmlPullParser parser) throws IOException, XmlPullParserException {

    List<String> result = new ArrayList<String>();
    //Required Tag is in calling function

    //holder for current line
    String curr_line = "";
    //get current tag name
    String current_tag_name = "";

    //while an end tag is not found
    while (parser.next() != XmlPullParser.END_TAG){
        //if a start tag is found continue
        if (parser.getEventType() != XmlPullParser.START_TAG){
            continue;
        }
        //get current tag
        current_tag_name = parser.getName();
        if (current_tag_name.equals(TAG_P)){
            curr_line = readText(parser);
        }
        else{
            skip(parser);
        }
        if (curr_line != null){
            result.add(curr_line);
        }
    }
    return result;
}