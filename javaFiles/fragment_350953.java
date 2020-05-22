int count = 0;
Text myText = null;
whlie(myRecordReader.nextKeyValue() == true)
{
     if (count == 4)
     {
           myText = (Text) myRecordReader.getCurrentValue();
           break;
     }

     count++;
 }

 if (myText != null) // we didn't hit the end; we have a record
 {
     ... // create the tuple
     return myTuple;
 }
 else
     return null;