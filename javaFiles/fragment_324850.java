public static String[] initial (String responsibleDepartment) {

String[] assignInitial = null;

if (responsibleDepartment.equals("Accounts Receivable")) {
    // Note the new String[] below
    assignInitial = new String[] {"Mike Davis", "Ben Jones", "Ann Smith"};
 }

if (responsibleDepartment.equals("Customer Service")) {
    assignInitial = new String[] {"Mary Wexler", "Turd Ferguson"};
 }

// Other if statements here

return assignInitial;