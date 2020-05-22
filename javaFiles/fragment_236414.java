Collection mySqlDates = new ArrayList();
mySqlDates.add(new java.sql.Date(...));
mySqlDates.add(new java.util.Date(...));

for (Object object : mySqlDates) {
    java.sql.Date sqlDate = (java.sql.Date) object; 
}