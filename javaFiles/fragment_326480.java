void allConfigurations(int n, int[] config, int index)
{
    if(index == n)// base case, the whole config has been filled
    {
        printConfiguration(config);
        return;
    }
    config[index] = 0; //create config with 0 at index
    allConfigurations(n, config, index + 1);
    config[index] = 1; //create config with 1 at index
    allConfigurations(n, config, index + 1);
}