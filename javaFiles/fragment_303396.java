ProcessBuilder pb2=new ProcessBuilder("/home/abhijeet/sample1.sh --ip=abc.txt --seqs=20");
 Process script_exec = pb2.start();
 OutputStream in = script_exec.getOutputStream();
 in.write("abc".getBytes());
 in.write("1".getBytes());
 in.write("10".getBytes());
 in.flush();
 in.close();