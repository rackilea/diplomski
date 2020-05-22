try{
        //String s=request.getParameter("data");
        String s="{\"cond\":{\"to_email\":\"b@b.c\"},\"ret\":\"all\"}";

        if(s == null || s.equals("")){
            //problem
            String json="{\"error\":\"error\",\"message\":\"no json data\"}";
        }else{              
            JSONObject obj= new JSONObject(s);

            JSONObject condObj=(JSONObject) obj.getJSONObject("cond");
            String returnObj= obj.getString("ret"); 

            System.out.println(condObj);    
            System.out.println(returnObj);
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }