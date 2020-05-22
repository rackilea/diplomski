# Hibernate specific property
dialect=org.hibernate.dialect.SQLServer2008Dialect

# This is the key line
url=jdbc:jtds:sqlserver://127.0.0.1;databaseName=yourDatabase;useNTLMv2=true;domain=nameOfDomain

user=windows_account
password=password
initial_size=5
max_active=30
max_wait=600000
min_idle=0
max_idle=10