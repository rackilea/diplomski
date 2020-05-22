public class Demo {

public static void main(String[] args) {
    int size = 4;
    int []buffer = new int[size];
    int []bufferCount = new int[size];
    int[] pages = {1,2,3,4,5,1,2,1,2,3,4,6,1,2,1,5,1};
    int pos = 0;
    for(int i = 0; i < pages.length; i++)
    {
        System.out.print("For page: "+pages[i]+"\t");
        if((pos = contains(buffer, pages[i])) > 0)
        {
            //already in buffer increment the count
            bufferCount[pos] ++;
        }
        else
        {
            //choose the element with least usage and remove it
            int toRemove = getLeastUsed(bufferCount);
            bufferCount[toRemove] = 1;
            buffer[toRemove] = pages[i];
        }
        printBuffer(buffer);
        System.out.print("\t");
        printBuffer(bufferCount);
        System.out.println();
    }
}

private static void printBuffer(int[] buffer) {
    // TODO Auto-generated method stub
    for(int i = 0; i < buffer.length; i++)
        System.out.print(buffer[i] + "");
}

private static int getLeastUsed(int[] bufferCount) {
    // TODO Auto-generated method stub
    int index = 0;
    int min = bufferCount[0];
    for(int i = 0; i < bufferCount.length; i++)
        if(bufferCount[i] < min)
        {
            min = bufferCount[i];
            index = i;
        }
    return index;
}

private static int contains(int[] buffer, int key) {
    // TODO Auto-generated method stub
    for(int i = 0; i < buffer.length; i++)
        if(buffer[ i ] == key)
            return i;
    return -1;
}