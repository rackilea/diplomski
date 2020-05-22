String[] cmd = new String[] {
    "mysql", 
    dbname,
    "--user=" + dbuser,
    "--password=" + dbpassword,
    "--xml",
    "-e",
    queryLine};