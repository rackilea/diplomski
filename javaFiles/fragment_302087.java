for(int i=0;i<model.size();i++){
                   JSONArray replyArrays = replyObject.getJSONArray(String.valueOf(model.get(i).comment_id));
                  //Initialise inside the loop 
                  ArrayList<ReplyCommentModel> replyModel = new ArrayList();
                   for(int j=0;j<replyArrays.length();j++){
                       JSONObject jsonObject1 = replyArrays.getJSONObject(j);
                       Integer id = jsonObject1.getInt("id");
                       String name = jsonObject1.getString("name");
                       String comment_image = jsonObject1.getString("photo");
                       Integer user_id = jsonObject1.getInt("user_id");
                       String comment = jsonObject1.getString("comment");
                       String added_on = jsonObject1.getString("addedon");
                       String imageURl = Constant.IMAGE_URL+Constant.COMMENT_USER_IMAGE_URL+comment_image;
                       replyModel.add(new ReplyCommentModel(comment,name,imageURl,added_on,user_id,id));
                   }
                   if(replyModel != null){
                       replyModelMap.put(String.valueOf(model.get(i).comment_id),replyModel);

                   }
               }