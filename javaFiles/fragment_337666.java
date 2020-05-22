double rand=uniform();
if(rand<0.7)
    agent.timeInService=uniform(15,30);
else if(rand<0.9)
    agent.timeInService=uniform(30,45);
else
    agent.timeInService=uniform(45,60);