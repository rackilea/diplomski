// Convert to array before sorting to avoid concurrency issues
    OperationDesc[] array = (OperationDesc[])overloads.toArray(
        new OperationDesc[overloads.size()]);


    Arrays.sort(array,
        new Comparator() {
            public int compare(Object o1, Object o2)
            {
                Method meth1 = ((OperationDesc)o1).getMethod();
                Method meth2 = ((OperationDesc)o2).getMethod();
                return (meth1.getParameterTypes().length -
                                     meth2.getParameterTypes().length);
            }
        });

    return array;
}