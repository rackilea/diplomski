boolean flag = false;
for(int i = 0; i < array.length; i++)
{
    if(array[i] == numChosen)
    {
        System.out.println(numChosen + " was found.");
        flag = true;
        break;
    }
}

if(!flag) {
    System.out.println(numChosen + " was not found.");
}