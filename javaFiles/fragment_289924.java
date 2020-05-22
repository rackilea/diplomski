Database database=CommandLineUtils.createDatabaseObject(OracleDriver.class.getClassLoader(), "jdbc:oracle:thin:@xxx.xx.xxx.xx:1521:XE", "archive_dbs", "123", "oracle.jdbc.driver.OracleDriver", "archive_dbs", null, null);
    //CommandLineUtils.doGenerateChangeLog("test.xml", database, "archive_dbs", null, null, null, null);uncomment to generate changelog
    Database database2=CommandLineUtils.createDatabaseObject(OracleDriver.class.getClassLoader(), "jdbc:oracle:thin:@yy.yy.yy.yy:1521:XE", "archive_dbs", "123", "oracle.jdbc.driver.OracleDriver", "archive_dbs", null, null);
   /* CommandLineUtils.doDiffToChangeLog("chageLog.xml", database2, database);//This can generate changeLog for diff
        ResourceAccessor resource=new FileSystemResourceAccessor();
        File sql=new File("SQLscript.sql");
        FileWriter writer=new FileWriter(sql);
        Liquibase base=new Liquibase("chageLog.xml",resource,database);
        base.update("Update",writer);//store diff sql to file,but donot execute it
        base.update("Update");//execute diff sql*/
        //CommandLineUtils.doDiff(database2, database);//show diff in console
   /* DatabaseSnapshot dbsnap1=new DatabaseSnapshot(database,"archive_dbs");
    DatabaseSnapshot dbsnap2=new DatabaseSnapshot(database2,"archive_dbs");*/
    Diff res=new Diff(database2,database);
    DiffResult result=res.compare();
    if(result.differencesFound()){
        System.out.println("Different");
    }else{
        System.out.println("Equal");
    }
    ByteArrayOutputStream baos=new ByteArrayOutputStream();
    PrintStream stream=new PrintStream(baos);
    result.printResult(stream);
    System.out.println(baos.toString());//show diff report
    System.out.println("Done");