Element.ByValue element = ...;
PointerByReference list = new PointerByReference();  
MyDll.INSTANCE.AddElementToList(element, list); // yes, Element.ByValue puts in Element

// but to get **Node** from filled PointerByReference you should reparse it like:
Node node = new Node(list.getValue());