String InitialDir = "c:\\";
String DirFilter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";

OpenFileDialog myDialog = new OpenFileDialog
{
    InitialDirectory = InitialDir,
    Filter = DirFilter,
    FilterIndex = 2,
    RestoreDirectory = true,
};            

if(myDialog.ShowDialog() == DialogResult.OK)
{
    try
    {
        FileInfo myFile = new FileInfo(myDialog.FileName);
        Directory.CreateDirectory(Path.Combine(myFile.DirectoryName, "subdir_name"));                    
    }
    catch 
    { 
        // exception handling here
        throw;
    }
}