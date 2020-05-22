ProcessBuilder pb = new ProcessBuilder("/usr/bin/bash", "-c", "echo HELLO > myfile.txt");
pb.directory(...);
pb.redirectErrorStream(true);
Process p = pb.start();
IOUtils.copy(p.getInputStream(), System.out);
p.waitFor();