//Before parsing, or if used frequently the map can be put outside the method and reused:
final HashMap<String, Integer> tags = new HashMap<String, Integer>(9, 1);
tags.put("encounters", 0);
tags.put("identity", 1);
tags.put("name", 2);
//And so on...

//in your parse-loop:
int tag = tags.get(xpp.getName());
switch(tag){
case 0: //Handle encounter tag...
break;
case 1: //Handle identity tag...
break;
case 2: //Handle name tag...
break;
//For all tags.
}