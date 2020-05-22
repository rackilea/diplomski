JSONObject childs = new JSONObject();
             JSONObject obj1 = new JSONObject();
            String nowparent=rst.getString("parent_name");
            if(parent.equals(nowparent)) {

                childs.put("parent",rst.getString("child_name"));
                childs.put("title", rst.getString("title"));
                nodes.put(childs);


            }else {
                nodes=new JSONArray();
                obj1.put("nodes", nodes);
                parent=nowparent;
                obj1.put("parent", nowparent);
                childs.put("parent",rst.getString("child_name"));
                childs.put("title", rst.getString("title"));
                nodes.put(childs);
                result.put(obj1);