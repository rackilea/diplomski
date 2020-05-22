NoSuchElementException mean whatever your code is trying to read is   not there 
mean there is no element which you are trying to read.
At line 47 i.e hr = inScan.nextInt();  inScan.nextLine(); 
your code is trying to read an int and nextline 
but there is no next line in your source file 
which basically will happen in the last iteration of your loop