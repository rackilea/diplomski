long maxtime = 0;
 long second_maxtime = 0;
 int maxPos;
 int secondMaxPos;

        for (int counter = 0; counter < timestampArray.length; counter++) {

                if (Long.parseLong(times[counter]) > maxtime) {
                    second_maxtime = maxtime;
                    maxtime = Long.parseLong(times[counter]);
                    maxPos = counter;
                } else if (Long.parseLong(times[counter]) > second_maxtime &&           Long.parseLong(times[counter]) != maxtime) {

                    second_maxtime = Long.parseLong(times[counter]);
                    secondMaxPos = counter;
                }
         }

String  last_text  = texts[maxPos];
String  second_last_text = texts[secondMaxPos];