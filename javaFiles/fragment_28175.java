// read each line
    while((dLine = depositFile.readLine()) != null) {
        double userDeposit;

        userDeposit=Double.parseDouble(dLine);
        userAccount.setDeposit(userDeposit);
        } // <--------------- HERE --------------------
    depositFile.close();} // <------------ AND HERE ---