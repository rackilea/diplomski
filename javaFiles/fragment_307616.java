USE master;
GO
ALTER DATABASE dbname SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
GO
USE dbname;
GO
-- now you can perform your "database cleanup" as you are the only
-- user allowed in.