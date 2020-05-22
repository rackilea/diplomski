classAList.forEach(instanceA ->
    myMap.compute(Key.key(instanceA), (k,b)-> {
        if(b==null) b=new ClassB(instanceA);
        else b.appendFieldA(instanceA.getFieldA());
        return b;
    })
);