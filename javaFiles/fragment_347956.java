for (LiveTvProgram program : ChannelsManager.getInstance().getSelectedPrograms()) {
    //Check if this program is in your bookmarks. As bookmarks is 
    //a Set, contains should be quite efficient
    if (bookmarks.contains(program.getTitle()) {                
        bookmarkList.add(program);
        //further improvement: you could check here if all bookmarks 
        //have been matched and exit the loop if yes
    }
}