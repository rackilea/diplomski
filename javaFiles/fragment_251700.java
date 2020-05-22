l = foo.size(); //Length of array list initialized before the loop
//If you have a loop starting from i=4 to 0 for the array [0,1,1,1,2]
//At any i, you do:
index = l - a[i];
System.out.print(foo.get(index)); 
//This would ultimately output 3 4 2 1 5 in your case

foo.remove(index); //Remove the element at this index from arraylist
l = l-1; //Since at every iteration we will remove one element