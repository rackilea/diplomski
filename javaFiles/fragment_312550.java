package de.enough.polish.browser.protocols;

import java.io.IOException;

import javax.microedition.io.StreamConnection;
import javax.microedition.midlet.MIDlet;

import de.enough.polish.browser.ProtocolHandler;

/**
 * Protocol handler to handle the <code>tel:</code> protocol. This class calls the given phonenumber on MIDP 2.0 phones.
 * Example: &lt;a href=&quot;tel:+441231234567#22&quot;&gt;Call Me&lt;/a&gt;
 * Note that this handler requires MIDP 2.0 or higher.
 * The tel protocol handler allows you to separate the phone number and the dialtone (dtmf) that should be send after
 * establishing the phone call using the '#' sign.
 * 
 * This protocol could actually be realized using the ExternalProtocolHandler as well, however in this
 * way we can deal post dial tones (DTMF) in a better way - in the HTML code they just need to be 
 * separated from the phonenumber using a '#'.
 */
public class TelProtocolHandler
extends ProtocolHandler
{
    private MIDlet midlet;

    /**
     * Creates an TellProtocolHandler object using the default "tel" protocol name.
     * 
     * @param midlet the midlet object of the application
     */
    public TelProtocolHandler(MIDlet midlet)
    {
        this( "tel", midlet );
    }

    /**
     * Creates an TelProtocolHandler object using the specified protocol name.
     * 
     * @param protocolName the name of the protocol to handle
     * @param midlet the midlet object of the application
     */
    public TelProtocolHandler(String protocolName, MIDlet midlet)
    {
        super( protocolName );
        this.midlet = midlet;
    }


    /* (non-Javadoc)
     * @see de.enough.polish.browser.ProtocolHandler#getConnection(java.lang.String)
     */
    public StreamConnection getConnection(String url) throws IOException
    {
        this.midlet.platformRequest( "tel:" + extractMsisdn(url));
        return null;
    }

    /**
     * Strips the MSISDN part off an url. 
     * In contrast to other protocol handlers, the external protocol handler only uses a single colon to
     * separate the external protocol from the folllowing protocol, e.g. external:http://www.j2mepolish.org
     * 
     * @param url the url to remove the protocol from
     * 
     * @return the host and part part of the given url
     */
    protected String extractMsisdn(String url)
    {
        String msisdn = url.substring(this.protocolName.length() + 1);
        String separator = null;
        //#if polish.dtmf.separator:defined
            //#= separator = "${polish.dtmf.separator}";
            //# if (!separator.equals("#")) {
                //# int pos = msisdn.indexOf('#');
                //# if (pos != -1) {
                    //# msisdn = msisdn.substring(0, pos) + separator + msisdn.substring(pos + 1); 
                //# }
            //# }
        //#endif
        return msisdn;
    }

}