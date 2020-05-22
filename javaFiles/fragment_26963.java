String suspiciousPath = "foo/bar/../../../baz.html";

Path current = Paths.get(".").toAbsolutePath().normalize();
Path test = current.resolve(suspiciousPath).toAbsolutePath().normalize();

System.out.println(current); // /home/vw5Vv0
System.out.println(test);    // /home/baz.html

boolean valid = test.startsWith(current);

System.out.println(valid ? "OK" : "DANGEROUS"); // DANGEROUS