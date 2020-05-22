HashMap<String,Integer> mymap = new HashMap<>();

while (videos.size() < MainActivity.userPrefrencesStaticArraylist.size() * 2)
{
    // Generate a random integer to get an entry random integer from the database array
    Random rand = new Random();
    int randomAlarmVidInt =  rand.nextInt(MainActivity.allVideosFromDatabaseStaticArray.size());

    // Find the category of the random video that was chosen
    String categoryForRandomGuess = MainActivity.allVideosFromDatabaseStaticArray.get(randomAlarmVidInt).getVideoCategory();

    //check if the hashmap has the category
    if(mymap.get(categoryForRandomGuess) == null)
     {
      mymap.put(categoryForRandomGuess,randomAlarmVidInt);
      videos.add(MainActivity.allVideosFromDatabaseStaticArray.get(randomAlarmVidInt));
     }
    else
    {//-1 means we already have 2 videos of the category.
     if(mymap.get(categoryForRandomGuess) == -1)
      continue;
     //if following condition is true, then its a duplicate video
     if(mymap.get(categoryForRandomGuess) == randomAlarmVidInt)
      continue;//skip the rest of loop and get new value of randomAlarmVidInt      
     else 
      {
       mymap.put(categoryForRandomGuess,-1);//second video added
       videos.add(MainActivity.allVideosFromDatabaseStaticArray.get(randomAlarmVidInt));
      }
    } 

   }