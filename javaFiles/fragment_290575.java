public void RunAsRoot(String[] cmds){
            Process p = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(p.getOutputStream());            
            for (String tmpCmd : cmds) {
                    os.writeBytes(tmpCmd+"\n");
            }           
            os.writeBytes("exit\n");  
            os.flush();
}