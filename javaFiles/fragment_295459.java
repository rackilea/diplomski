import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Copy;
import org.apache.tools.ant.types.FileSet;

//Create the new copy class
Copy copier = new Copy();
//Set the target directory wrapped into File object
copier.setTodir(new File("my/target/directory"));
//The project's definition is requested for the execution of Copy
copier.setProject(new Project());

//Before run its request to define the FileSet object
FileSet fs = new FileSet();

//Now setup the base directory to copy
fs.setDir(new File("my/source/directory"));
//If its require, define the inner file or directory to exclude from the copy action
fs.setExcludes("fileExcluded");
fs.setExcludes("directory/to/exclude");

//Link the FileSet to copy
copier.addFileset(fs);
//And go!
copier.execute();