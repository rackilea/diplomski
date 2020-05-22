try{
    Process su = Runtime.getRuntime().exec("su");
    DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());

    outputStream.writeBytes("pm uninstall package_name\n");
    outputStream.flush();

    outputStream.writeBytes("exit\n");
    outputStream.flush();
    su.waitFor();
}catch(IOException e){
    throw new Exception(e);
}catch(InterruptedException e){
    throw new Exception(e);
}