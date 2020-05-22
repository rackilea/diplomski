boolean isAvailble = false;
...
// Some code
...
for (int i = 0; i < arr.length; i++) {
       x = arr[i] % 2;
       if (x == 0) {
         System.out.println(arr[i]);
         isAvailble = true;
       }
}

if (! isAvailable) {  
     System.out.println("Even number not found in array.");
}