public class Analyzer {
   System.out.printf("    1     |    %d     |   %d |   %d\n" , 
                Simulator.simulate(2, 1, 0.71, 15, 1200), 
                Simulator.simulate(5, 1, 0.71, 15, 1200), 
                Simulator.simulate(10, 1, 0.71, 15, 1200)      
              );
}