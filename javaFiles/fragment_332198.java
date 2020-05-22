BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

//code
for (int i = 0; i < 1000000; i++) {
    log.write("test");
}

for loop: 0.21200