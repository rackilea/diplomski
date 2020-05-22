Object[] arguments = {
     new Integer(7),
     new Date(System.currentTimeMillis()),
     "a disturbance in the Force"
 };

 String result = MessageFormat.format(
     "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
     arguments);

 output: At 12:30 PM on Jul 3, 2053, there was a disturbance
           in the Force on planet 7.