Console console = System.getConsole();
if (console == null) {System.exit(42)}
while(true) (
    String option = console.readLine("What would you like to ask this ATM? %d to Quit, %d to deposit, %d to withdraw:", 0, 1, 2;
    switch (option) {
      case "1": acceptDeposit(); break;
      case "2": acceptWithdrawl(); break;
      case "0": quit(); break;
      default: break;
    }
}