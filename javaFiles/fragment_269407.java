long diffsecs  = (y2k38 - now) / 1000;
    long diffmins  = (diffsecs / 60) % 60;
    long diffhours = (diffsecs / 60 / 60) % 24;
    long diffdays  = diffsecs / 60 / 60 / 24;
    diffsecs       = diffsecs % 60;

    System.out.printf("%d days, %d hours, %d minutes, d seconds\n",
        diffdays, diffhours, diffmins, diffsecs);