String [] allRecords = {"[BEGIN RECORD]", "[ID]1", "[cName]Agnes", "[Age]12", "[END RECORD]", "[BEGIN RECORD]", "[ID]2", "[cName]Hellen", "[Age]5", "[END RECORD]", "[BEGIN RECORD]", "[ID]3", "[cName]Jack", "[Age]34", "[END RECORD]"};

String beginRecord = "[BEGIN RECORD]";
String endRecord = "[END RECORD]";                
int foundIndex = 0;
int foundEnd = 0;

      for (int i=0; i<allRecords.length; i++) {
      if (endRecord.equals(allRecords[i])) {
           foundEnd = i;    
           break;   
           }                
      }

      //by saving the location of the end of the previous record, and picking up from there, your logic can now be repeatedly in a loop until all valid records are consumed from the input
      foundEnd = foundEnd-1; //arrays are zero based


      for (int i=0; i<allRecords.length; i++) {
          if (beginRecord.equals(allRecords[i])) {
             foundIndex = i+1;  //arrays are zero based
             String [] partAllRecords = Arrays.copyOfRange(allRecords, foundIndex, foundIndex+foundEnd);                   
             System.out.println(Arrays.toString(partAllRecords)); 
             //prints below arrays in logcat
             //[[ID]1, [cName]Agnes, [Age]12]
             //[[ID]2, [cName]Hellen, [Age]5]
             //[[ID]3, [cName]Jack, [Age]34]
         }
      }