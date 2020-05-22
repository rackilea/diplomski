int max( int[] array ){ return max( array, 0, array.length - 1 ); }

int max( int[] array, int low, int high )
{
    if (low == high) {
        return array[low];
    } 
    else {
        int mid = (high + low) / 2;
        int leftmax = max(array, low, mid );
        int rightmax = max(array, mid, high );
        if (leftmax > rightmax) {
            return leftmax;
        } 
        else {
            return rightmax;
        }

    }
}