create table Users(
  ID           int auto_generated primary key,
  LastName     varchar( 16 ) not null,
  FirstName    varchar( 16 ) not null,
  UserType     char( 1 ) check( UserType in( 'M', 'P' )
);