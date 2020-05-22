int produceNumber(int [] arr)
{

    int [] amx = new int[10];
    int mx = 0;
    for(int i=0;i<arr.length;i++)
    {
        int idx = 0;
        while(arr[i] > 0)
        {
            amx[idx] = Math.max(amx[idx], arr[i] % 10);
            arr[i] /= 10;
            idx++;
            mx = Math.max(mx, idx);
        }
    }

    //now build the number
    int res = 0, factor = 1;
    for(int i=0; i<mx;i++){
        res += amx[i] * factor;
        factor *= 10;
    }

    return res;
}