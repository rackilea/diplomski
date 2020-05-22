Process process = Runtime.getRuntime().exec("sc query "+nameOfService);
    Scanner reader = new Scanner(process.getInputStream(), "UTF-8");
    while(reader.hasNextLine())
        if(reader.nextLine().contains(serviceNAME))
            return true;
    return false;