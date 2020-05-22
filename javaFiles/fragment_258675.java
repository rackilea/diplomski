@Override
public int compare(Object o1, Object o2) {
    if (o1 instanceof T1) {
        if (o2 instanceof T2) {
            T1 t1=(T1)o1;
            T2 t2=(T2)o2;
            return t1.x-t2.y;
        } else {
           ...
        }
    } else {
        ...
    }
}