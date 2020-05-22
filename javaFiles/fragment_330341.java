for(int i = 0; i < POPULATION_SIZE; i++){ // loop through the population (0-99)
    int sum = 0;
    for(int j = 0; j < 16; j++){ // loop through the individuals (in this case the cities) 
        sum += COST[j][j+1]; 
    }
    fitness[i] = sum;
}