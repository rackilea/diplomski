let helper = []
let maxLength = 0;
for each string in array
if (len(string) >maxLength){
     maxLength = len(string);
     clear(helper)
}
if (len(string) == maxLength)
      helper.add(string)
}
return helper;