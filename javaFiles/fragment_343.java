window.onload = (function(){
   var code = document.getElementsByClassName('code');
   for( i=0 ; i < code.length ; i++ ){
      var text = code[i].innerHTML;
      text = text.replace('public', 'oranges');
      code[i].innerHTML = text;
      console.log(text);
   }
})