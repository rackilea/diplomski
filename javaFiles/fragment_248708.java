package de.scrum_master.aspect;

import javax.sql.DataSource;

import de.scrum_master.app.BaseClass;

public aspect DataSourceConnectionAspect {
  declare parents: BaseClass implements DataSource;

  before() : execution(public java.sql.Connection javax.sql.DataSource+.getConnection(..)) {
    System.out.println(thisJoinPoint);
  }
}