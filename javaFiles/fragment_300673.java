package com.bbc.enums;

import lombok.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;
import java.util.stream.Collectors;


public class StackOverFlow {
    public static void main(String[] args) {
        List<AclList> aclLists = Arrays.asList(
                new AclList("Mas", 2, 10, "Mas1", 2, 5),
                new AclList("Mas", 2, 10, "Mas2", 0, 5),
                new AclList("USR", 5, 7, "USR1", 4, 4),
                new AclList("USR", 5, 7, "USR2", 1, 3),
                new AclList("Inv", 8, 14, "Inv1", 3, 5),
                new AclList("Inv", 8, 14, "Inv2", 2, 3),
                new AclList("Inv", 8, 14, "Inv3", 2, 3),
                new AclList("Inv", 8, 14, "Inv4", 1, 3)

        );

        Map<String, Map<Integer, Map<Integer, List<AclList>>>> collect = aclLists.stream()
                .collect(Collectors.groupingBy(AclList::getHead, Collectors.groupingBy(AclList::getAssignedHead,
                        Collectors.groupingBy(AclList::getTotalHead))));

        List<HashMap<String, Object>> resList = new ArrayList<>();
        collect.forEach((k1, v1) -> {
            HashMap<String, Object> res = new HashMap<>();
            res.put("type", k1);
            v1.forEach((k2, v2) -> {
                res.put("assigned", k2);
                v2.forEach((k3, v3) -> {
                    res.put("total", k3);
                    List<HashMap<String, Object>> list = new ArrayList<>();
                    v3.forEach(aclList -> {
                        HashMap<String, Object> map1 = new HashMap<>();
                        map1.put("type", aclList.getChild());
                        map1.put("assigned", aclList.getAssignedChild());
                        map1.put("total", aclList.getTotalChild());
                        list.add(map1);
                    });
                    res.put("subType", list);
                });
            });
            resList.add(res);
        });
        System.out.println(resList);
        // if you want json response then
        System.out.println(listmap_to_json_string(resList));
    }


    public static String listmap_to_json_string(List<HashMap<String, Object>> list) {
        JSONArray json_arr = new JSONArray();
        for (Map<String, Object> map : list) {
            JSONObject json_obj = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                try {
                    json_obj.put(key, value);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            json_arr.put(json_obj);
        }
        return json_arr.toString();
    }
}


@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
class AclList {
    String head;
    Integer assignedHead;
    Integer totalHead;
    String child;
    Integer assignedChild;
    Integer totalChild;
}