DEBUG - Executing prepared SQL statement [select username, password, true from apiclient where username='?'] 
DEBUG - Fetching JDBC Connection from DataSource 
...
DEBUG - Caching SQL error codes for DataSource [com.zaxxer.hikari.HikariDataSource@3bcd426c]: database product name is 'H2' 
DEBUG - Unable to translate SQLException with Error code '90008', will now try the fallback translator

...

DEBUG - Access is denied (user is anonymous); redirecting to authentication entry point 
org.springframework.security.access.AccessDeniedException: Access is denied
    at org.springframework.security.access.vote.AffirmativeBased.decide(AffirmativeBased.java:84)