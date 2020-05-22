//quick javascript example of the regex, you'd replace the quote char with whichever character your currently testing
var test='id,text,date\n1,"bob, ""hi\n..."", sigh",1/1/2011';
console.log(test.replace(/"(""|.|\n|\r)*?"/gm,""));

id,text,date
1,,1/1/2012