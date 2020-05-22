while ((line = br.readLine()) != null) {

    System.out.println(line);

    if(line.contains("CompanyName"))
    {
        String[] splits = line.split("=");
        String desired = splits[1]; // second position in the string array.
    }
}