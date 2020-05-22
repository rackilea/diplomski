int interpolatedframes = 10000;
    double[] rednoise1 = SigGen.redNoise(duration, interpolatedframes);
    while(i<rednoise1.length-1)
    {
        selectedNumber = (int)Math.floor(Math.abs((100*(rednoise1[i]+0.5)+100)));
        if(i+selectedNumber < rednoise1.length-1) {
            rednoise1 = SigGen.alterRedNoise(rednoise1, i, selectedNumber);
        }
        else
        {
            break;
        }
        i+=selectedNumber;
    }