/* multicast SSDP M-SEARCH example for 
 * finding the IP Address of a Roku
 * device. For more info go to: 
 * http://sdkdocs.roku.com/display/sdkdoc/External+Control+Guide 
 */

import java.io.*;
import java.net.*;

class msearchSSDPRequest {
    public static void main(String args[]) throws Exception {
        /* create byte arrays to hold our send and response data */
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        /* our M-SEARCH data as a byte array */
        String MSEARCH = "M-SEARCH * HTTP/1.1\nHost: 239.255.255.250:1900\nMan: \"ssdp:discover\"\nST: roku:ecp\n"; 
        sendData = MSEARCH.getBytes();

        /* create a packet from our data destined for 239.255.255.250:1900 */
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("239.255.255.250"), 1900);

        /* send packet to the socket we're creating */
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.send(sendPacket);

        /* recieve response and store in our receivePacket */
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        /* get the response as a string */
        String response = new String(receivePacket.getData());

        /* print the response */
        System.out.println(response);

        /* close the socket */
        clientSocket.close();
    }
}