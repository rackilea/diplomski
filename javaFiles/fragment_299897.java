Object obj = data.get("a");
Type1 type1obj;
if(obj instanceof Type1) {
    type1obj = (Type1) obj;
} else {
    //to print error log or do some workaround
}