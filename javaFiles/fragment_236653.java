package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestListObjectArray {

public static void main(String[] args) {
    Object[] obj = { 42628, 567898 };
    Object[] obj1 = { 426238, 5674898 };
    Object[] obj2 = { 42621, 5678498 };
    Object[] obj3 = { 42627, 5678698 };
    Object[] obj4 = { 42627, };
    Object[] obj5 = { 42627, 1000 };

    List<Object[]> listObjectArr = new ArrayList<>();
    listObjectArr.add(obj);
    listObjectArr.add(obj1);
    listObjectArr.add(obj2);
    listObjectArr.add(obj3);
    listObjectArr.add(obj4);
    listObjectArr.add(obj5);

    Map<Object, List<Object>> ObjectMap = new HashMap<>();
    List<Object[]> restinctionList = new ArrayList<>();

    List<List<?>> restinctionDummyList = new ArrayList<>();
    for (Object[] resArr : listObjectArr) {
        List<Object> targetList = Arrays.asList(resArr);
        restinctionDummyList.add(targetList);
    }
    restinctionDummyList.forEach(list -> {
        List<Object> tmpArrayList = new ArrayList<>(list);
        if (ObjectMap.get(list.get(0)) != null) {
            List<Object> resultList = ObjectMap.get(list.get(0));
            tmpArrayList.remove(0);
            resultList.addAll(tmpArrayList);
        } else {
            ObjectMap.put(list.get(0), tmpArrayList);           
        }
    });

    System.out.println(ObjectMap);
}
}