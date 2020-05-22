if (accountNo.length() > 15) {
        if (accountNo.substring(16, accountNo.length()).matches("000")) {
            accountNo = accountNo.substring(1, 16);
        } else if (accountNo.substring(17, accountNo.length()).matches("00")) {
            accountNo = accountNo.substring(1, 17);
        } else if (accountNo.substring(18, accountNo.length()).matches("0")) {
            accountNo = accountNo.substring(1, 18);
        }
    }