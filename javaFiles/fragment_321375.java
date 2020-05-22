Before adding any instance
--------------------------
@relation TestInstances

@attribute content string
@attribute @@class@@ {A,B}

@data

--------------------------
After adding a instance
--------------------------
@relation TestInstances

@attribute content string
@attribute @@class@@ {A,B}

@data
'This is a string!',A
--------------------------
After adding second instance
--------------------------
@relation TestInstances

@attribute content string
@attribute @@class@@ {A,B}

@data
'This is a string!',A
'This is second string!',B
--------------------------