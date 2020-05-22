for (int i =0; i< shortDist.length -1; i++)
        {
            for (int r = i+1; r <shortDist.length-1 && r< i + 7; r ++){
                d = Math.min(d, shortDist[i].sqrDist(shortDist[r]));
            }
        }