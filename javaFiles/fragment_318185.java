function run(){
  try {
    out.value = (new RegExp(regex.value)).test(input.value) ?
    'valid' : 'invalid';
    error.childNodes[0].nodeValue = '';
   } catch(e){
     out.value = 'Invalid regex: ';
         error.childNodes[0].nodeValue = e;
   }
}
input.oninput = run;
regex.oninput = run;
run();