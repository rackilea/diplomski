public class HelloAgent
{
    public static void agentmain(String agentArgs, Instrumentation inst)
    {
        System.out.println(agentArgs);
        System.out.println("Hi from the agent!");
        System.out.println("I've got instrumentation!: " + inst);
    }
}

public static void main(String[] args)
{
    AgentLoader.loadAgentClass(HelloAgent.class.getName(), "Hello!");
}