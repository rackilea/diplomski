String cmd= "cmd /C si viewhistory --fields=revision --project="+fileName; 
Process p = Runtime.getRuntime().exec(cmd) ;  
s1 = new ReadStream("stdin", p.getInputStream ());
s2 = new ReadStream("stderr", p.getErrorStream ());
s1.start ();
s2.start ();
p.waitFor();        
} catch (Exception e) {  
e.printStackTrace();  
} finally {
    if(p != null)
        p.destroy();
}