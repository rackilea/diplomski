^              //start of anchor
  (
    \/         //match forward slash
    (\w+)      //match any word character, match atleast once 
  )+           //match this group atleast once (this group captures /app/etc/etc)
  \/?          //match a forward slash, make it optional (to also capture /app/)
  (\.\w{5,})?  //match any word after a . with 5 characters or more, make it optional
  \??          //match a ?, make the match optional
  ([^.]+)?     //match anything not containing a . 1 or more times, make the match optional
$              //end of anchor