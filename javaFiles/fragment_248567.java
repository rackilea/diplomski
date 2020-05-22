package com.example.helloworld;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import <my_star_io_library>;

public class HelloWorld extends Activity 
{
    private Context context;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);

        //Save context
        context = this;

        StarIOPort port = null; 
        byte[] texttoprint = new byte[]{0x1b, 0x40, 0x1b,0x74,0x0D,(byte) 0x91,(byte) 0x92,(byte) 0x93,(byte) 0x94,(byte) 0x95,(byte) 0x96,(byte) 0x97,(byte) 0x98,(byte) 0x99,0x0A,0x0A,0x0A,0x0A,0x0A}; 

        try  
        { 
            port = StarIOPort.getPort(portName, portSettings, 10000, context); 
            port.writePort(textToPrint, 0, textToPrint.length); 
            port.writePort(new byte[] {0x0a}, 0, 1); 
        } 
        catch (StarIOPortException e) 
        { 
            Builder dialog = new AlertDialog.Builder(context); 
            dialog.setNegativeButton("Ok", null); 
            AlertDialog alert = dialog.create(); 
            alert.setTitle("Failure"); 
            alert.setMessage("Failed to connect to printer"); 
            alert.show(); 
        } 
    }
}