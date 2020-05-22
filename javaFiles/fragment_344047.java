public MySerializableObjectList myList;
if(getArguments != null)
    myList = (MySerializableObjectList)getArguments().getSerializable("myArrayTag");

List<MySerializableObject> myListObject;
if(myList != null)
    myListObject = myList.getMySerializableObjectList();