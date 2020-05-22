JSONArray videoIds = finalObject.getJSONArray("videoID");
for (int s = 0; s < videoIds.length(); s++){

                          String videoID = videoIds.optString(s);
                          postModel.setVideoID(videoID);
                             postModelList.add(postModel);
                        }