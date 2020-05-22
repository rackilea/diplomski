Consumer<LoanData> textAreaUpdater = 
    loanData -> Platform.runLater(() -> {
        textArea.appendText("The rate is : " + loanData.getRate() + "\n");
        textArea.appendText("The number of years is: " + loanData.getYear() + "\n");
        textArea.appendText("Loan amount is: " + loanData.getLoan() + "\n\n");
    });

new Thread(new HandleAClient(socket, textAreaUpdater)).start();