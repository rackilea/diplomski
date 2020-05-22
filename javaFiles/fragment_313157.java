function compareWords(words){
  var longestWord = '';
  for(var i = 0; i < words.length; i++){
    if(words[i].length > longestWord.length){
      longestWord = words[i];
    }
  }
  return longestWord;
}
var words = ['gunslinger', 'gundam', 'dragon', 'shirt', 'unicorn', 'internationalization'];
compareWords(words);