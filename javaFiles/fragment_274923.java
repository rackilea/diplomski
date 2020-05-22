import javax.sdp.*;
import javax.sip.*;

ContentTypeHeader contentType = (ContentTypeHeader) msg.getHeader(ContentTypeHeader.NAME);
ContentLengthHeader contentLen = (ContentLengthHeader) msg.getHeader(ContentLengthHeader.NAME);

if ( contentLen.getContentLength() > 0 && contentType.getContentSubType().equals("sdp") ){
    String charset = null;

    if (contentType != null)
        charset = contentType.getParameter("charset");
    if (charset == null)
        charset = "UTF-8"; // RFC 3261

    //Save the SDP content in a String
    byte[] rawContent = msg.getRawContent();
    String sdpContent = new String(rawContent, charset);

    //Use the static method of SdpFactory to parse the content
    SdpFactory sdpFactory = SdpFactory.getInstance();
    SessionDescription sessionDescription = sdpFactory.createSessionDescription(sdpContent);
    Origin origin = sessionDescription.getOrigin();

    System.out.println("A Session ID is " + origin.getSessionId());
} else {
    System.out.println("It is not a SDP content");
}