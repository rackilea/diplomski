const System = {
     out: {
       println: console.log
     }
   };
   
   System.out.println("Enter an integer to be factored:");
   let startInt = 784784;
   const expectedResult = '2 x 2 x 2 x 2 x 7 x 7 x 7 x 11 x 13'

   if(startInt % 2 == 0 || startInt % 3 == 0 || startInt % 5 == 0 || startInt % 7 == 0 || startInt % 11 == 0 || startInt % 13 == 0) {
        let result = '';
        for(let mod = 2; mod <= startInt; mod++) {
            while (startInt%mod === 0) {
                startInt /= mod;
                // Fix this line
                result += mod + (mod < startInt ? ' x ' : '');
            }
        }
        System.out.println(result);
        if (result !== expectedResult) {
           System.out.println('Fail');
        } else {
           System.out.println('Everything is Ok');
        }
    } else {
        System.out.println(startInt+" = "+startInt);
        System.out.println(startInt+" is a prime number.");
    }