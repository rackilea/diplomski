console.clear();
var input = "sinus1+sinus2x+3moveout";
do {
  console.log(input);
  input = input.replace(/(sinus\dx?\+)?(?:\d?moveout|(<<handled>>))$/, function(m,lead){
    return lead ? "<<handled>>" : "{{all done}}"
  });
} while (input.indexOf("<<") !== -1);
console.log(input);