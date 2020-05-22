VAR x REFCURSOR;
 exec :x := my_fun( 'x' );
 print :x;

         X          Y
---------- ----------
         1         99
         2         98
         3         97
         4         96
         5         95
         6         94
         7         93
         8         92
         9         91
        10         90

10 rows selected.