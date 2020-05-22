List<FileServer> fsList = new ArrayList<FileServer>();
for(FSSpec spec : fileServerSpecs)
{
    FileServer fs = FileServerFactory.create(spec);
    fsList.add(fs);
}

// do something with your list of file servers.