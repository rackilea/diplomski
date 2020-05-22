int[] results = new int[numsamples];
        for(int i=0; i<numsamples; i++) {
            int currentPosition = 0;

            while(randomValue > cdf[currentPosition] && currentPosition < cdf.length) {
                currentPosition++; //Check the next one.
            }

            if(currentPosition < cdf.length) { //It worked!
                results[i] = values[currentPosition];
            } else { //It didn't work.. let's fail gracefully I guess.
                results[i] = values[cdf.length-1]; 
                     // And assign it the last value.
            }
        }

        //Now we're done and can return the results!
        return results;
    } else { //Without replacement.
        throw new Exception("This is unimplemented!");
    }
}