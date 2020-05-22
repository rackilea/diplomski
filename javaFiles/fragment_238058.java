@Test
    public void retrieveItems_test(@Mocked(methods={"getAbsolutePath"}) final File target,@Mocked FileUtils util){
        new Expectations(){
            {
                prop.get("FileBase");
                result="home";
                target.getAbsolutePath();
                result="absolute";
                FileUtils.FolderFinder("absolute", "test");
                result=new File[]{new File("file1")};
            }
        };
        List<String> retrieveItems = logic.retrieveItems();
        assertSame(1, retrieveItems.size());
    }