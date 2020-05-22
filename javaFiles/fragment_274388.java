package dk.dalsgaarddata;

import lotus.domino.AgentBase;
import lotus.domino.AgentContext;
import lotus.domino.Database;
import lotus.domino.DocumentCollection;
import lotus.domino.NotesException;
import lotus.domino.NotesFactory;
import lotus.domino.NotesThread;
import lotus.domino.Session;
import dk.dalsgaarddata.debug.DebugAgentContext;

/*  ------------------------------------------------------------------------------------
    Created: 2009.04.21/Jda
    Revised: 2009.04.29/Jda - v.1.1

    Agent template.... 
    ------------------------------------------------------------------------------------ */

public class AgentTemplate extends AgentBase {
    // DEBUG: For Eclipse debugging - see main method at the end of this class.

    // Beginning of "ordinary" Lotus Notes/Domino Agent....
    private Session mySession = null;
    private AgentContext myContext = null;
    private DD_BackendLog myLog = null;

    private void cleanUp() {
        try {
            if (null != myLog)
                myLog.end();
            if (null != mySession)
                mySession.recycle();
        } catch (NotesException ne) {
            System.err.println("Error cleaning up log and Session.");
        }
    }

    // Lotus Notes/Domino entry point...
    public void NotesMain() {
        try {
            if (mySession == null) {
                mySession = getSession();
                myContext = mySession.getAgentContext();
            }
            SessionContext.getInstance(mySession, myContext);
            myLog = SessionContext.getLog();

            System.out.println("NotesMain Started....");
            // Your code goes here....

            myLog.information(".... completed!");
        } catch (NotesException ne) {
            myLog.error("Agent ERROR: NotesException = " + ne.text);
            myLog.writeStackTrace(ne);
        } catch (Exception e) {
            myLog.error("Agent ERROR: Exception = " + e.getMessage());
            myLog.writeStackTrace(e);
        } finally {
            cleanUp();
        }
    }

    /*  Instructions for debugging!!
    // TODO - adjust run configuration
        You need to add VM arguments, e.g.:

            -Dsun.boot.library.path="c:\\Lotus\\Notes;c:\\Lotus\\Notes\\jvm\\bin"

     ... and you need to add a PATH environment variable, e.g.:

            PATH    c:\Lotus\Notes
    */

    // Remember to rename these constructors when duplicating this code to a new agent!!!
    // ... if not handled by Eclipse when pasting a copy ;-)
    public AgentTemplate() {
    }

    public AgentTemplate(Session s, AgentContext c) {
        this.mySession = s;
        this.myContext = c;
    }

    // Entry point for Java program (when running from Eclipse)
    public static void main(String[] args) {
        // By example from Bob Balaban "The two-headed beast". See more at:
        // http://www.bobzblog.com/tuxedoguy.nsf/dx/DominoAgents-Eclipse_v2.pdf/$file/DominoAgents-Eclipse_v2.pdf
        System.out.println("main Starting....");
        Session s = null;
        Database d = null;
        DocumentCollection dc = null;
        AgentContext ctx = null;

        System.out.println("NotesThread.sinitThread()....");
        NotesThread.sinitThread();
        try {
            System.out.println("createSession....");
            s = NotesFactory.createSession();
            System.out.println("set database....");
            d = s.getDatabase(DebugAgentContext.ECLIPSE_SERVER, DebugAgentContext.ECLIPSE_DATABASE);
            System.out.println("Database: " + d.getFileName() + " on " + d.getServer());
            System.out.println("set debug context....");
            ctx = new DebugAgentContext(s, d, dc);
            // Create the agent object, invoke it on NotesMain(), the way Domino does
            System.out.println("create agent object....");
            AgentTemplate agent = new AgentTemplate(s, ctx);
            System.out.println("call agent....");
            agent.NotesMain();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null)
                    s.recycle();
            } catch (Exception x) {
            }
            NotesThread.stermThread();
        }
    } // end main - and Eclipse entry point

}