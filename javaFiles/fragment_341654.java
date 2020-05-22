package mycompany;

import com.engidea.comm.CommPort;
import com.engidea.comm.CommPortIdentifier;
import com.engidea.comm.SerialPort;
import com.engidea.comm.SerialPortEvent;
import com.engidea.comm.SerialPortEventListener;
import com.engidea.win32jcom.WinjcomIdentifier;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.applet.*;
import java.security.*;

/*
  WinJcom is a native interface to serial ports in java.
  Copyright 2007 by Damiano Bolla, Jcomm@engidea.com

  This library is free software; you can redistribute it and/or
  modify it under the terms of the GNU Library General Public
  License as published by the Free Software Foundation; either
  version 2 of the License, or (at your option) any later version.
  This can be used with commercial products and you are not obliged 
  to share your work with anybody.

  This library is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
  Library General Public License for more details.

  You should have received a copy of the GNU Library General Public
  License along with this library; if not, write to the Free
  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

/**
 * Simple class that can list system ports and allow IO
 */
public class PortWriter extends Applet {

    private CommPortIdentifier portIdentifier;
    private SerialPort serport;

    public static void main(String[] args) {}
    public void init() {
    System.out.println("Booting RS232 Java Applet...");
    }

    public void Sends(String port, String message) {

    final String com_port = port;
    final String send_message = message;

    AccessController.doPrivileged(new PrivilegedAction<Object>() {
        public Object run() {

        try {
            portIdentifier = new WinjcomIdentifier(0);
            try {
            selectComport(com_port);
            new Thread(new PortReader()).start();
            try {
                System.out.println(com_port + ": " + send_message);
                typeSendBytes(send_message);
            } catch (Exception e) {
                System.out.println("Couldn't send data to " + com_port);
            }
            } catch (IOException e) {
            System.out.println("Couldn't connect to " + com_port);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
        }
    });
    }

    private void typeSendBytes( String message ) {  
    try {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String aStr = "";
        if (aStr != null) {
        aStr = message + "\r\n";
        // WARNING: be careful, you shoulod select the encoding !
        // This will timeout if you have FLOW CONTROL and theline is stuck !
        byte []buf = aStr.getBytes();
        serport.write(buf,0,buf.length);
        }
    } catch ( Exception exc ) {
        exc.printStackTrace();
    }
    }

    private SerialPort openPort ( String portName ) throws IOException {
    try {
        CommPort aPort = portIdentifier.getCommPort(portName);
        aPort.open();
        return (SerialPort)aPort;
    }
    catch ( Exception exc ) {
        //System.out.println("exc="+exc);
        //exc.printStackTrace();
        throw exc;
    }
    }

    private void selectComport ( String portName ) throws IOException {

    try {
        serport = openPort(portName);
        serport.setSerialPortParams(9600,8, SerialPort.STOPBITS_2, SerialPort.PARITY_NONE);
        serport.enableReceiveTimeout(20000);
        serport.setEventListener(new EventListener());

        serport.notifyOnDSR(true);
        serport.notifyOnCarrierDetect(true);
        serport.notifyOnCTS(true);
    } catch (IOException exc) {
        //System.out.println("Exc="+exc);
        //exc.printStackTrace();
        throw exc;
    }

    }


private final class EventListener implements SerialPortEventListener
  {
  public void serialEvent(SerialPortEvent ev)
    {
    System.out.println("Got event="+ev);
    }
  }


private final class PortReader implements Runnable
  {
  public void run()
    {
    try
      {
      // This will timeout if nothing is received in the specified time.
      byte []buff = new byte[1];
      while (  serport.read(buff,0,buff.length) > 0 )
        {
        // NOTE: you should be checking the encoding !
        System.out.print(new String(buff));
        }
      }
    catch ( Exception exc )
      {
      exc.printStackTrace();
      }
    }
  }


}