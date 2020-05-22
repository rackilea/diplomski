try
{
    int processComplete; 
    Process runtimeProcess = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u root -pabc db_Name -r D:/backup.sql");
    processComplete = runtimeProcess.waitFor();
    if(processComplete==1)
    {

        JOptionPane.showMessageDialog(null, "Backup Failed");
    }
    else if(processComplete==0)
    {
        JOptionPane.showMessageDialog(null,"\n Backup created Successfully.");
    }

}
catch(Exception e)
{
     JOptionPane.showMessageDialog(null,e);
}