for(int j = 0;j<here.length();j++)
{
    if(here.charAt(j) == c)
        break;  
    ret.add(here.substring(0,j+1) + c + here.substring(j+1,here.length()));
}