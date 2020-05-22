package com.test.www;

    import java.util.ArrayList;
    import java.util.List;

    public final class Test  {

        /** <p> 
         *  Finds digit at {@code digitAt} position. Runs in O(n) where n is the max
         *  digits of the 'full' number (see below), e.g. for {@code digitAt} = 10^10, 
         *  n ~ 5, for 10^20, n ~ 10. 
         *  <p>
         *  The algorithm is thus basically a direct 'closed form' calculation. 
         *  It finds the quadratic equation to calculate triangular numbers (x(x+1)/2) but also
         *  takes into a account the transitions from 9 to 10, from 99 to 100, etc. and 
         *  adjusts the quadratic equation accordingly. This finds the last 'full' number
         *  on each 'line' (see below). The rest follows from there.
         *     
         */
        public static char findDigitAt(long digitAt) {

            /* The line number where digitAt points to, where:
             *  1, 1 2, 1 2 3, 1 2 3 4, etc. ->
             *  1        <- line 1
             *  1 2      <- line 2
             *  1 2 3    <- line 3
             *  1 2 3 4  <- line 4
             */
            long line;

            // ---- Get number of digits of 'full' numbers where digitAt at points, e.g. 
            //      if digitAt = 55 or 56 then digits = the number of digits in 10 which is 2.

            long nines = 0L; // = 9 on first iteration, 99 on second, etc.
            long digits = 0;
            long cutoff = 0; // Cutoff of digitAt where number of digits change
            while (digitAt > cutoff) {
                digits++;
                nines = nines + Math.round(Math.pow(10L, digits-1L)) * 9L;

                long nines2 = 0L;
                cutoff = 0L;
                for (long i = 1L; i <= digits; i++) {
                    cutoff = cutoff + ((nines-nines2)*(nines-nines2+1)/2);
                    nines2 = nines2 + Math.round(Math.pow(10L, i-1L)) * 9L;
                }
            }

            /* We build a quadratic equation to take us from digitAt to line */

            double r = 0; // Result of solved quadratic equation 
                          // Must be double since we're using Sqrt()
                          // even though result is always an integer.

            // ---- Define the coefficients of the quadratic equation
            long xSquared = digits;
            long x = 0L;
            long c = 0L;
            nines = 0L; // = 9 on first iteration, 99 on second, etc.

            for (long i = 1L; i <= digits; i++) {
                x = x + (-2L*nines + 1L);
                c = c + (nines * (nines - 1L));
                nines = nines + Math.round(Math.pow(10L, i-1L)) * 9L;
            }
            // ---- Solve quadratic equation, i.e. y - ax^2 + bx + c  =>  x = [ -b +/- sqrt(b^2 - 4ac) ] / 2 
            r = (-x + Math.sqrt(x*x - 4L*xSquared*(c-2L*digitAt))) / (2L*xSquared); 

            // Make r an integer
            line = ((long) r) + 1L;
            if (r - Math.floor(r) == 0.0) { // Simply takes care of special case
                line = line - 1L;
            }

            /* Now we have the line number ! */

            // ---- Calculate the last number on the line
            long lastNum = 0; 
            nines = 0;
            for (int i = 1; i <= digits; i++) {
                long pline = line - nines; 
                lastNum = lastNum + (pline * (pline+1))/2;
                nines = nines + Math.round(Math.pow(10, i-1)) * 9;
            }

            /* The hard work is done now. The piece of cryptic code below simply counts
             * back from LastNum to digitAt to find first the 'full' number at that point
             * and then finally counts back in the string representation of 'full' number
             * to find the actual digit.
             */
            long fullNumber = 0L;
            long line_decs = 1 + (int) Math.log10(line);
            boolean done = false;
            long nb;
            long a1 = Math.round(Math.pow(10, line_decs-1));
            long count_back = 0;
            while (!done) {
                nb = lastNum - (line - a1) * line_decs; 
                if (nb-(line_decs-1) <= digitAt) {
                    fullNumber = line - (lastNum - digitAt) / line_decs;
                    count_back = (lastNum - digitAt) % line_decs; 
                    done = true;
                } else {
                    lastNum = nb-(line_decs); 
                    line = a1-1; 
                    line_decs--; 
                    a1 = a1 / 10; 
                }
            }

            String numStr = String.valueOf(fullNumber);
            char digit = numStr.charAt(numStr.length() - (int) count_back - 1);  

            //System.out.println("digitAt = " + digitAt + "  -  fullNumber =  " + fullNumber + "  -  digit = " + digit);
            System.out.println("Found " + digit + " at position " + digitAt);
            return digit;
        }

        public static void main(String... args) {
            long t = System.currentTimeMillis();

            List<Long> testList = new ArrayList<Long>();
            testList.add(1L); testList.add(2L); testList.add(3L); testList.add(9L);
            testList.add(2147483647L);
            for (int i = 1; i <= 18; i++) {
                testList.add( Math.round(Math.pow(10, i-1)) * 10);
            }
            //testList.add(4611686018427387903L); // OVERFLOW OCCURS

            for (Long testValue : testList) {
                char digit = findDigitAt(testValue);
            }

            long took = t = System.currentTimeMillis() - t;
            System.out.println("Calculation of all above took: " + t + "ms");
        }


    }