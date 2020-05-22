phraseList[0]="";
for(int i = 0; i < phrase.length(); i++)
  {
     if(phrase.charAt(i) == '#')
     {
        c++;
        phraseList[c]="";
     }else if(phrase.charAt(i) != '#')
     {
        phraseList[c] += phrase.charAt(i);
     }
  }