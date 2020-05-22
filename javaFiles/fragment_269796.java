public class AccountUtility {

        private Map<String, String> fetchAccountDetailsFromFile(String filePath){
            //Create Map
            Map<String, String> accountDetails = new HashMap<>();

            try(BufferedReader fileReader = new BufferedReader(new FileReader(new File(filePath)))){
                String eachLine = "";
                while((eachLine = fileReader.readLine()) != null){
                    //Split at '<>'
                    String[] details = eachLine.split("<>");
                    //if each line does not have 3 fields, continue.
                    if(details.length < 3){
                        continue;
                    }

                    //get details of each field.
                    String accountNumber = details[0];
                    String customerName = details[1];
                    String balance = details[2];

                    /*
                     * Create name and balance combined String
                     * Ex: nameBalPair = Smith|15,000 
                     */
                    String nameBalPair = customerName + "|" + balance;

                    //add into Map
                    accountDetails.put(accountNumber, nameBalPair);
                }
            }catch(IOException e){
                e.printStackTrace();
            }

            //return Map
            return accountDetails;
        }
//Yet to add accountApp() method
    }