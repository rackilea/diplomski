public static void main(String[] args)
{ 
      System.out.println(getAgent().getAgentName());
      System.err.println(getAgent().getAgentName());
      someTextArea.append("The agent name is: " + getAgent().getAgentName());
      // etc
}