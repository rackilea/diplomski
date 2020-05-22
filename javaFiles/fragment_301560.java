Enumeration<Agent> AgentEnum = AgentList.keys();
while(AgentEnum.hasMoreElements()) {
    Agent key = AgentEnum.nextElement();
    YOUR_CLASS value = AgentList.get(key);
    value.whatever();
    ...
}