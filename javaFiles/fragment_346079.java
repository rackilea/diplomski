String line;
while ((line = keyInput.readLine()) != null && 
       !line.trim().equals("BYE")) {
    oStream.println(line);
    answer = iStream.readLine();
    if (answer != null) {
        System.out.println(answer);
    }
}