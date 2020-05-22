boolean accept = false;
for (int i = 0; i < object.numProps(); i++) {
   if (object.prop[i] > criteria[i]) {
       accept = true;
       break;
   } else if (object.prop[i] < criteria[i]) 
       break;
   // loop continues only if object.prop[i] == criteria[i]
}