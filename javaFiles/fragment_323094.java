// (x,y) is the center point;
// assert ( x>=0 && y>=0 && x<n && y<n );
int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, m = n-1;

for( int i = (x==0)? 0 : x-1, x_max = (x==m)? m : x+1; i <= x_max; i++ )
  for( int j = (y==0)? 0 : y-1, y_max = (y==m)? m : y+1; j <= y_max; j++ ) {
    if( arr[i][j] < min )
      min = arr[i][j];
    else if ( arr[i][j] > max )
      max = arr[i][j];
    }

// now you have the max/min values set