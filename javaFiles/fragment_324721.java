// .. imports

// create a changelog
liquibase.changelog.DatabaseChangeLog databaseChangeLog = new liquibase.changelog.DatabaseChangeLog();

// create a changeset
liquibase.changelog.ChangeSet changeSet = new liquibase.changelog.ChangeSet("1", "prates", false, false, "", null, null, true, null, databaseChangeLog);

// create a drop table change
liquibase.change.core.DropTableChange dropTableChange = new liquibase.change.core.DropTableChange();

dropTableChange.setTableName("person");

changeSet.addChange(dropTableChange);

// add created changeset to changelog
databaseChangeLog.addChangeSet(changeSet);

// create a new serializer
XMLChangeLogSerializer xmlChangeLogSerializer = new XMLChangeLogSerializer();

String output = null;

ByteArrayOutputStream baos = new ByteArrayOutputStream();

xmlChangeLogSerializer.write(databaseChangeLog.getChangeSets(), baos);

output = baos.toString();

// print output
System.out.println(output);