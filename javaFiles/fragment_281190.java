int inipopulationsize = 25;
        double[][] population;
        Random randGen = new Random();
        double randNum = randGen.nextDouble();
        double ranP = 0.5;// outside loops
        population = new double[inipopulationsize][25]; // out


            for (int k = 0; k < inipopulationsize; k++){
                for (int j = 0; j < 25; j++){

                    randNum = randGen.nextDouble();//i assume you want new random every time

                    if (randNum <= ranP){
                        population[k][j] = 1;
                    }
                    else
                        population[k][j] = 0;
                }//j loop
            }//k loop
System.out.println(Arrays.deepToString(population));