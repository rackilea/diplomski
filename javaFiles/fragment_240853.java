if (!file.exists()) {
        file.createNewFile();
    }

    // Line being changed
    FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);


    BufferedWriter  bw = new BufferedWriter(fw);

    bw.append(String.valueOf(Bank.users));
    bw.close();