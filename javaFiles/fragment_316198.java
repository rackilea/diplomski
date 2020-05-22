AlChannelCreateAsyncTask.TaskListenerInterface channelCreateTaskListener = new AlChannelCreateAsyncTask.TaskListenerInterface() {
        @Override
        public void onSuccess(Channel channel, Context context) {
            Log.i("Group","Group response :"+channel);

        }

        @Override
        public void onFailure(ChannelFeedApiResponse channelFeedApiResponse, Context context) {

        }

    };

    List<String> groupMembersUserIdList = new ArrayList<>();
    groupMembersUserIdList.add("user1");
    groupMembersUserIdList.add("user2");
    groupMembersUserIdList.add("user3");//Note:while creating group exclude logged in userId from list
    ChannelInfo channelInfo = new ChannelInfo("Group name",groupMembersUserIdList);
    channelInfo.setType(Channel.GroupType.PUBLIC.getValue().intValue()); //group type
    channelInfo.setImageUrl(""); //pass group image link URL
    //channelInfo.setChannelMetadata(channelMetadata); //Optional option for setting group meta data
    //channelInfo.setClientGroupId(clientGroupId); //Optional if you have your own groupId then you can pass here

    AlChannelCreateAsyncTask channelCreateAsyncTask = new AlChannelCreateAsyncTask(context,channelInfo,channelCreateTaskListener);
    channelCreateAsyncTask.execute();