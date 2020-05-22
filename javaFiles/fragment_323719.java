import lotus.domino.*;

public class JavaAgent extends AgentBase {

    public void NotesMain() {

        try {
          Session session = getSession();
          AgentContext agentContext = session.getAgentContext();

      // (Your code goes here) 
          Document doc = agentContext.getDocumentContext();
          System.out.println
        (doc.getItemValueString("http_user_agent"));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}