BufferedReader br = new BufferedReader(
    new InputStreamReader(
        new FileInputStream(new File("yourTextFile")), 
        "[your file's encoding]"
    )
);