//this could be implemented as `toString` of ShareAnalyzer
    private static void printShareInfo(ShareAnalyzer shareAnalyzer){
        System.out.println("Best time & price for buying is " + shareAnalyzer.getBuyTime() + " minutes after opening for " + shareAnalyzer.getBuyPrice() + " EUR." + "\n"
                + "Best time & price for selling is " + shareAnalyzer.getSellTime() + " minutes after opening for " + shareAnalyzer.getSellPrice() + " EUR." + "\n"
                + "Profit: " + shareAnalyzer.getProfit());
    }