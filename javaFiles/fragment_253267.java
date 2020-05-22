private void writeAccounts(List<Account> accounts) throws IOException {
    OutputStream file = new FileOutputStream("Accounts.txt");
    OutputStream buffer = new BufferedOutputStream(file);
    ObjectOutput output = new ObjectOutputStream(buffer);

    try {
        for (Account account : accounts) {        
            output.writeObject(account);
        }
        output.close();
    }
    finally {
        output.close();
    }
}