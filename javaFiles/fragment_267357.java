SimluationClass
{
    public int startSim()
    {
      ...
    }
}

class SimulationView
{

    SimulationClass sim = new SimulationClass();      

    private void init()
    {

      JButton button = new JButton("Start");
      button.addActionListener(new ActionListener() {
          void actionPerformed(...) 
          {
               sim.startSim()
          }
          });
    }
}