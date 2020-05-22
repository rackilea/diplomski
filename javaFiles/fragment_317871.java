class InterpreterSingletonList {  
    public static final void Set<Interpreter> is = new HashSet();
    void printToAll(String s) {
         for (Interpreter i: is) {
             i.print(s);
         }
    }
}



package bsh.util;

import java.io.*;

import java.net.Socket;
import java.net.ServerSocket;
import bsh.*;

/**
    BeanShell remote session server.
    Starts instances of bsh for client connections.
    Note: the sessiond effectively maps all connections to the same interpreter
    (shared namespace).
*/
public class Sessiond extends Thread
{
    private ServerSocket ss;
    NameSpace globalNameSpace;

    public Sessiond(NameSpace globalNameSpace, int port) throws IOException
    {
        ss = new ServerSocket(port);
        this.globalNameSpace = globalNameSpace;
    }

    public void run()
    {
        try
        {
            while(true)
                new SessiondConnection(globalNameSpace, ss.accept()).start();
        }
        catch(IOException e) { System.out.println(e); }
    }
}

class SessiondConnection extends Thread
{
    NameSpace globalNameSpace;
    Socket client;

    SessiondConnection(NameSpace globalNameSpace, Socket client)
    {
        this.client = client;
        this.globalNameSpace = globalNameSpace;
    }

    public void run()
    {
        try
        {
            InputStream in = client.getInputStream();
            PrintStream out = new PrintStream(client.getOutputStream());
            /* this is the one you're looking for */
                        Interpreter i = new Interpreter( 
                new InputStreamReader(in), out, out, true, globalNameSpace);
            i.setExitOnEOF( false ); // don't exit interp
                    /*store the interpreter on the list*/
                    InterpreterSingletonList.is.add(i);
            i.run();
                    /*remove it (i.run() blocks)*/
                    InterpreterSingletonList.is.remove(i);
        }
        catch(IOException e) { System.out.println(e); }
    }
}