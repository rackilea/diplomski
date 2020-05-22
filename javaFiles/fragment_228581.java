function whatsMyName() {
   return function iKnowIt() {
     for(const [key, value] of Object.entries(this))
        if(value === iKnowIt)
           console.log(key);
   };
 }