int i=0  
 while (in.hasNextLine())

   {  

      name = in.nextLine();
      vote = in.nextInt();


      //Do whatever here: print, save name and vote, etc..
      //f.e: create an array and save info there. Assuming both name and vote are 
      //string, create a 2d String array.
     array[i][0]=name;
     array[i][1]=vote;

     //if you want to individually store name and votes, create two arrays.
     nameArray[i] = name;
     voteArray[i] = vote;
     i++;

   }