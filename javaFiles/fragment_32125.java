String[][] childString = new String[parent.size()][child.size()];
int i = 0;
int j = 0;
for(ArrayList<String> al : child)
{
    for(String s: al)
    {
        childString[i][j] = s;
        j++;
    }
    i++;
    j = 0;
}