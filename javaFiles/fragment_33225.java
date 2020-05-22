Pattern pattern = Pattern.compile("\\|");
TextFileReader reader = new TextFileReader(context, "big_file.txt");

while (reader.hasMoreData) 
{
  String group = reader.readNextSubstring('#');
  String[] info = pattern.split(group);
  MyObject objA = new MyObject(info[0], info[1], info[2], info[3]);
  ...
}