callback : function(data){
   //data is the returned List<Person> serialized to JSON
   var modifiedObj = new Object();
   modifiedObj.persons = data;
   modifiedObj.extraAttributes = [{"attribute1": 1,"attribute2": 2,"attribute3":3}]
}