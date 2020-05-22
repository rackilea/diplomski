listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ChannelList channelList= list.get(position);
                // now you have all data of clicked ChannelList 
                // do whatever you like
                //channelList.getVideoUrl(); etc as your getter method

            }

        }
    });