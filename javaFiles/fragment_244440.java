public static void main()
{
    String[] wagon1 = {
            "  _____________|____  ",
            " /_| ____________ |_\\ ",
            "/   |____________|   \\",
            "\\                    /",
            " \\__________________/ ",
            "  (O)(O)      (O)(O)  "
        };
    String[] wagon2 = {
            "         ++         ",
            "         ||         ",
            "_________||_________",
            "|  ___ ___ ___ ___ |",
            "|  |_| |_| |_| |_| |",
            "|__________________|",
            "|__________________|",
            "   (O)        (O)   "
        };

    String[][] train = {wagon1, wagon2, wagon1, wagon2};

    int max_height = 0;

    for(int i = 0; i < train.length; i++)
    {
        String[] wagon = train[i];
        if(wagon.length > max_height)
        {
            max_height = wagon.length;
        }
    }

    //printTrain(train, max_height);

    for(int i = 0; i < train.length; i++)
    {
        train[i] = getHeightedArray(max_height, train[i]);
        train[i] = getWidthedArray(train[i]);
    }

    printTrain(train, max_height);
}

public static String[] getHeightedArray(int heightNeeded, String[] wagon)
{
    String[] return_arr = new String[heightNeeded];
    for(int i = 0; i < heightNeeded-wagon.length; i++)
    {
        return_arr[i] = "";
    }
    for(int i = 0; i < wagon.length; i++)
    {
        return_arr[i+heightNeeded-wagon.length] = wagon[i];
    }
    return return_arr;
}

public static String[] getWidthedArray(String[] wagon)
{
    String[] return_wagon = new String[wagon.length];

    int max_width = 0;
    for(int i = 0; i < wagon.length; i++)
    {
        if(wagon[i].length() > max_width)
        {
            max_width = wagon[i].length();
        }
    }

    for(int i = 0; i < wagon.length; i++)
    {
        return_wagon[i] = wagon[i];
        for(int j = 0; j < max_width-wagon[i].length(); j++)
        {
            return_wagon[i] += " ";
        }
    }
    return return_wagon;
}

public static void printTrain(String[][] train, int max_height)
{
    int heightOfConnector = 2; // 1 means the connector is at the wheel level, so I chose 2
    for(int i = 0; i < max_height; i++) // Controls the height, 0 means the top
    {
        for(int j = 0; j < train.length; j++) // Controls the wagon index
        {
            if(heightOfConnector == max_height-i && j != train.length-1)
                System.out.print(train[j][i]+" ++ ");
            else
                System.out.print(train[j][i]+"    ");
        }
        System.out.println();
    }
}