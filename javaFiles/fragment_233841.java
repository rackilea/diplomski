int reds = 0;
int greens = 0;
int blues = 0;

...

        for(int k = 0; k < f - 1; k++){
            for(int w = 0; w < f - 1; w++) {
                reds += avgArr[k][w].getR();    // <-- note the +=
                greens += avgArr[k][w].getG();
                blues += avgArr[k][w].getB();
            }
        }

        int count = (f-1)*(f-1);
        Color avgColor = new Color(reds/count, greens/count, blues/count);