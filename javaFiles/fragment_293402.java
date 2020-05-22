newLength = $entries.length + 1;
entries = new Object[ newLength ] ;

for(i = 0 ; i < newLength - 1 ; i++) {
        entries[i] = $entries[i];
        //...
}

entries[ newLength - 1 ] = addition;