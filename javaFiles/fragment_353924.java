int numberOfFollowers; 
    numberOfFollowers = user.getFollowersCount(); 

            //CREATE ARRAYS FOR FOLLOWER IDS
    long cursor = -1;
    long[] fArray = new long[numberOfFollowers];
    long[] local = new long[5000];


    IDs ids = twitter.getFollowersIDs(name, cursor);
    int j = 0;

            int x = 5000;
    int durchgang = 1;
    int d_anzahl = 1 + numberOfFollowers / 5000;
    //STROE FOLLOWER IDS IN ARRAYS
    do 
    {                       
        ids = twitter.getFollowersIDs(name, cursor);            
        local = twitter.getFollowersIDs(name, cursor).getIDs();
        System.out.println("Durchgang: " + durchgang + " / " + d_anzahl );          
        System.arraycopy(local, 0, fArray, j * x , local.length);           
        j++;
        durchgang++;

        cursor = ids.getNextCursor();           
    } while (ids.hasNext());