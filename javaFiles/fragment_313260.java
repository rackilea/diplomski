from 'src/main/java'
eachFile { currentFile ->
    String contents = new File(currentFile.getSourcePath()).text
    if(!contents.contains("public class")) {
        currentFile.exclude()
    }
}