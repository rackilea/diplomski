if(Long.parseLong(inputString+(char)key) > 2147483647)
    {
        //"inputString+(char)key" Will fit into an Integer!
        inputString += (char)key;
    }
    else
    {
        //"inputString+(char)key" Will NOT fit into an Integer!
    }