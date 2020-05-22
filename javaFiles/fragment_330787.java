int batchInterval = 1000;

ps = con.prepareStatements(sql);
for(int i=0; i<data.size(); i++) {
        String[] fields = data.get(i).split("=");
        ps.setString(1, fields[0]);
        ps.setString(2, fields[1]);
        ps.setString(3, fields[2]);
        ps.setString(4, fields[3]);
        ps.setString(5, fields[0].trim()+"."+fields[1].trim()+"."+fields[2].trim()+"."+fields[3].trim()); //Index
        ps.setString(6, fields[0].trim()+"."+fields[1].trim()); //PARN Index
        ps.addBatch();

        if (i % batchInterval == 0) ps.executeBatch();
}

ps.executeBatch();
ps.close();
con.close();