// (x,y) is the center point
int x_min = x - 1, y_min = y - 1,
    x_max = x + 1, y_max = y + 1,
    min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
if ( x_min < 0 )
  x_min = 0;
if ( y_min < 0 )
  y_min = 0;
if ( x_max > n - 1 ) // you can set 'int m = n - 1;'
  x_max = n - 1;     // and use m here instead if you wish
if ( y_max > n - 1 )
  y_max = n - 1;

for( int i = x_min; i <= x_max; i++ )
  for( int j = y_min; j <= y_max; j++ ) {
    if( arr[i][j] < min )
      min = arr[i][j];
    else if ( arr[i][j] > max )
      max = arr[i][j];
    }

// now you have the max/min values set