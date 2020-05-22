Process p=Runtime.getRuntime().exec("wget http://www.duckduckgo.com/");

    BufferedReader perr=new BufferedReader(new InputStreamReader(p.getErrorStream()));
    BufferedReader pout=new BufferedReader(new InputStreamReader(p.getInputStream()));
    // We read stderror first from wget, because it spits the progress information into stderr
    for (String s=perr.readLine(); s!=null; s=perr.readLine())
    {
        System.out.println("Stderr from p: "+s);
    }
    for (String s=pout.readLine(); s!=null; s=pout.readLine())
    {
        System.out.println("Stdout from p: "+s);
    }
    // if you need to check whether the command actually returned normally
    int returnCode = p.waitFor();
    perr.close();
    pout.close();

    System.out.println("Returned from p with exit code "+returnCode);

    p=Runtime.getRuntime().exec("pscp -pw dontuseplainpwusesshkeys index.html user@10.0.0.11:");
    perr=new BufferedReader(new InputStreamReader(p.getErrorStream()));
    pout=new BufferedReader(new InputStreamReader(p.getInputStream()));
    // We read stdout of pscp first because pscp spits stuff into stdout.
    // The process will block if the buffer gets full and does not get emptied.
    for (String s=pout.readLine(); s!=null; s=pout.readLine())
    {
        System.out.println("Stdout from p: "+s);
    }
    for (String s=perr.readLine(); s!=null; s=perr.readLine())
    {
        System.out.println("Stderr from p: "+s);
    }

    int returnCode1 = p.waitFor();
    perr.close();
    pout.close();

    System.out.println("Process exited with return code "+returnCode1);