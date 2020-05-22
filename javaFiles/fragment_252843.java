Process p = Runtime.getRuntime().exec(new String[] {"sh", "-c",
            "less >/dev/tty"});
    OutputStream out = p.getOutputStream();
    out.write("Lengthy message".getBytes());
    out.close();
    System.out.println("=> "+p.waitFor());