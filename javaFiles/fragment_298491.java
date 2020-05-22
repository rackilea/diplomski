Vector<Struct> structs = new Vector<>();
while(errors.next()){
    errMsgList.add(errors.getString(1));
}
Struct struct = new Struct(objectName, status, errMsgList);
structs.add(struct);
.
.
.

return structs;