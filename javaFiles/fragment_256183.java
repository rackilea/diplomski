CREATE TABLE app.honscores ( //schema name is before the table name
  idhonscores INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  Name varchar(25) NOT NULL,
  Characters VARCHAR(25) NOT NULL,
  Kills integer NOT NULL,
  Deaths integer NOT NULL,
  Assists integer NOT NULL,
  XPM integer NOT NULL,
  CK integer NOT NULL
);