public void close(int lotNumber, String description)
{
 for(Lot lot : lots) 
 {
     System.out.println(lotNumber + description); //print lot number and description.
     Bid highestBid = lot.getHighestBid(); //get the highest bid for the lot.
     if (highestBid != null) 
     {
         String name = highestBid.getBidder().getName();
         System.out.println(name + " " + highestBid.getValue()); //print bidder and highest bid value
        }     
     else
     {
         System.out.println("Not sold"); //if not sold print "Not sold"
        }
    }
}