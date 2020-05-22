try (
    Reader reader = Files.newBufferedReader(Paths.get("So58792579.csv"));
    CSVReader csvReader = new CSVReader(reader);
) {
    String[] nextRecord;
    while ((nextRecord = csvReader.readNext()) != null) {
        CreditCardInfo creditCardInfo = new CreditCardInfo();
        creditCardInfo.setFirstname(nextRecord[0]);
        creditCardInfo.setLastname(nextRecord[1].trim()); //trim() for ignoring leading space
        creditCardInfo.setCardNumber(nextRecord[2].trim().split(" ")[0]);
        creditCardInfo.setExpiryDate(nextRecord[2].trim().split(" ")[1]);

        System.out.println(creditCardInfo.toString());
    }
} catch (IOException e) {
    e.printStackTrace();
}