if ( fileNames[i].isDirectory() )
{
   songsToAdd.addAll(addSongList(dir + "/" + files[i].getName()));
}
else if (files[i].getName().contains(".mp3") || files[i].getName().contains(".wma"))
{
   songsToAdd.add(files[i]);
}