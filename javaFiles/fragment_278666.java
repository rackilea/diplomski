package de.scrum_master.aspect;

import de.scrum_master.app.Population;

public aspect StatisticsAspect {
  private static int year = 0;

  pointcut operation(Population population) :
    execution(* Population.newYear()) && target(population);

  after(Population population) : operation(population) {
    System.out.printf("Population for year %d = %d%n", ++year, population.getSize());
  }
}