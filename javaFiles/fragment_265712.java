if (score >= 0 & score <= 100)
    { outFile.printf("%10.2f",score);
        scoreCount++;
        average = score + average;
    }
    else
        outFile.printf("                **%.2f",score);}