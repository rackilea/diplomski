URL dirUrl = getClass().getResource("/mydir");
VirtualFile vfDir = VFS.getChild(dirUrl.toURI());
List<VirtualFile> jsonVFs = vfDir.getChildren(new VirtualFileFilter() {
    @Override
    public boolean accepts(VirtualFile file) {
        return file.getName().toLowerCase().endsWith(".json");
    }
});
for (int i = 0; i < jsonVFs.size(); i++) {
    VirtualFile vf = jsonVFs.get(i);
    File f = vf.getPhysicalFile();
    MyClass fromJson = objectMapper.readValue(f, MyClass.class); 
    // Do something with it..
}