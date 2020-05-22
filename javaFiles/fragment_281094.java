NativeObject point;
    NativeArray elementArray;
    for(int i = 0; i < array.getLength(); i++){
        if(array.get(i)!=null){
            elementArray = (NativeArray)array.get(i);                
            System.out.println("name: " + elementArray.get("name", elementArray));
            point = (NativeObject) arrayFirstElement.get("point", arrayFirstElement);
            //System.out.println("point.x: " +  NativeObject.getProperty(point, "x"));
            //System.out.println("point.y: " +  NativeObject.getProperty(point, "y"));
            System.out.println("object point has: ");
            for ( Object propertyId : NativeObject.getPropertyIds(point)){
                System.out.println("property "+ propertyId + " has value " + NativeObject.getProperty(point, propertyId.toString()));
            } 
        }
    }