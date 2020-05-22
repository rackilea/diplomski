int recordsPerSecond = 100;
        int totalRecords = 1000;
        long sleepTime = 900; // in milis (Assuming that 100 mili seconds lapsed in inserting 100 rows)

        for(int i=1; i<=totalRecords; i++){

            if(i%recordsPerSecond==0)
                Thread.sleep(sleepTime);

            DAO.insert();
        }