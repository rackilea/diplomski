if (source == b1)
        display += "1";

    //...etc

    if (source == blb)
        display += "#";

    if (source == resetB)
    {
        display = "";
        counter = 0;
    }

    if (counter == 3)
        display += "-";

    if (counter == 6)
        display += "-";