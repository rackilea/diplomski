int totalAmount = 15000;
int initialInstallment = 5000;
int numberOfInstallments = 5;

// Calculate the height of each installment
int installment = (totalAmount - initialInstallment) / numberOfInstallments;

// Print to screen
for(int i = 1; i <= numberOfInstallments) {
    System.out.println("Installment " + i + "  " + installment);
}
System.out.println("Total " + (totalAmount - initialInstallment));