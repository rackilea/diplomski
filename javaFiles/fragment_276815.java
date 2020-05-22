int index = 0;

for(int i = 0; i<randomList.size();i++)
{
        if(randomList.get(i)instanceof Integer)
        {
            intArray[index++]= (Integer) randomList.get(i);
        }
}