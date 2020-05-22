if (x.equals("d")) {
            Customer2 currentRecord = bankRecords.getLast();
            currentRecord.deposit(20);
        }
        if (x.equals("w")) {
            Customer2 currentRecord = bankRecords.getLast();
            currentRecord.withdraw(10);
        }