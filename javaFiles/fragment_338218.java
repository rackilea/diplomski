Arrays.sort(files, new Comparator<Object>()
{
    public int compare(Object o1, Object o2) {

        if (((File)o1).lastModified() > ((File)o2).lastModified()) {
            return -1;
        } else if (((File)o1).lastModified() < ((File)o2).lastModified()) {
            return +1;
        } else {
            return 0;
        }
    }

});

for (int i = 0; i < files.length; i++)
 {
      file = files[i];
      Log.d("Count",file.getPath());
      it.add (file.getPath());
  }