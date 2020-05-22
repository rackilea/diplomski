reversePrint([5,1,34,12,7]) {
   reversePrint([1,34,12,7]) { // <-- this list IS A COPY, it just ignores the first number
      reversePrint([34,12,7]) {
         reversePrint([12,7]) {
            reversePrint([7]) {
               reversePrint([]);
               print(7); // <-- this is the first number of the current list
            };
            print(12);
         };
         print(34);
      };
      print(1);
   };
   print(5);
};