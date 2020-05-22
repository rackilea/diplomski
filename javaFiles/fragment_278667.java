package de.scrum_master.aspect;

import de.scrum_master.app.Population;

public aspect StatisticsAspect pertarget(execution(Population.new(..))) {
  private int year = 0;

  pointcut operation(Population population) :
    execution(* Population.newYear()) && target(population);

  after(Population population) : operation(population) {
    System.out.printf("%s size for year %d = %d%n", population, ++year, population.getSize());
  }
}