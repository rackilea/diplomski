<scriptselector language="javascript">
    importPackage(java.io);
    importPackage(org.apache.tools.ant.util);

    fileUtils = FileUtils.getFileUtils();
    f = self.getFile();
    println(f);
    if( f.getAbsolutePath().endsWith(".xyz") ){
        fis = new FileInputStream(f.getAbsolutePath());
        isr = new InputStreamReader(fis);
        println('reading it!');
        fileContents = fileUtils.readFully(isr);
        println(fileContents);
        self.setSelected(true);
    }
</scriptselector>