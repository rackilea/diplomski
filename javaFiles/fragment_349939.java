public static void main(String[] args) {
    List<StockData> listSD1 = new ArrayList<StockData>();
    List<StockData> listSD2 = new ArrayList<StockData>();

    StockData sd1 = new StockData();
    StockData sd2 = new StockData();
    List<ShareBean> listShares1 = new ArrayList<ShareBean>();
    List<ShareBean> listShares2 = new ArrayList<ShareBean>();

    //create the shares for sd1
    listShares1.add(new ShareBean("goog", 3));
    listShares1.add(new ShareBean("ibm", 5));
    listShares1.add(new ShareBean("gs", 0));
    listShares1.add(new ShareBean("msft", 0));
    listShares1.add(new ShareBean("c", 1));

    //create the shares for sd2
    listShares2.add(new ShareBean("goog", 0));
    listShares2.add(new ShareBean("ibm", 1));
    listShares2.add(new ShareBean("gs", 3));
    listShares2.add(new ShareBean("msft", 0));
    listShares2.add(new ShareBean("c", 5));

    //set their ids
    sd1.setId(1);
    sd2.setId(2);

    //set the dates (using calendars)
    sd1.setDate(Calendar.getInstance());
    sd2.setDate(Calendar.getInstance());

    //and finally set the shares
    sd1.setShares(listShares1);
    sd2.setShares(listShares2);

    //now add each object to each list.  the lists will be exacly the same
    listSD1.add(sd1);
    listSD1.add(sd2);
    listSD2.add(sd1);
    listSD2.add(sd2);

    //now the lists are ready, and we can compare them
    //I put the comparewithsecondarray method in the StockData class, but it could go anywhere
    //I also overrode the "toString" method to make the output more readable (in both StockData and ShareBean)
    System.out.println(Arrays.toString(sd1.comparewithsecondarray(listSD1, listSD2).toArray()));
}