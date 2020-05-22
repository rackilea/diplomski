JLabel appFinderLabel = new JLabel("AppFinder");        
JLabel musicxMatchLabel = new JLabel("musicXmatch");
JLabel tuneWikiLabel = new JLabel("TuneWiki");

JLabel yourMusicLabel = new JLabel("YOUR MUSIC");
JLabel songsLabel = new JLabel("Songs");
JLabel albumsLabel = new JLabel("Albums");
JLabel artistsLabel = new JLabel("Artists");
JLabel localFilesLabel = new JLabel("Local Files");

/* 
 * Set icons, background and stuff if you need to
 * A good option would be use undecorated JButtons instead of JLabels
 */

JSideBar sideBar = new JSideBar(true);
sideBar.addItem(appFinderLabel, Component.LEFT_ALIGNMENT);
sideBar.addItem(musicxMatchLabel, Component.LEFT_ALIGNMENT);
sideBar.addItem(tuneWikiLabel, Component.LEFT_ALIGNMENT);

sideBar.addVerticalSpace(20);

sideBar.addItem(yourMusicLabel, Component.LEFT_ALIGNMENT);
sideBar.addItem(songsLabel, Component.LEFT_ALIGNMENT);
sideBar.addItem(albumsLabel, Component.LEFT_ALIGNMENT);
sideBar.addItem(artistsLabel, Component.LEFT_ALIGNMENT);
sideBar.addItem(localFilesLabel, Component.LEFT_ALIGNMENT);