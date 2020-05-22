int count = helpjson.length();
InboxData itemsData[] = new InboxData[count];
for(int i=0;i < count ;i++){ 
    itemsData[i] = new InboxData();
    //initialize your InboxData through data you get from helpjson.getXXX
    ....
}