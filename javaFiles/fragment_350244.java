finally 
{           
    // Print out statuses
    printStatus();

    for(UserCredential user : creds)
    {
        Accel.setRow(user.getMap(), user.getRowIndex());
    }

    try {
        Accel.writeToFile();
    } catch (IOException e)  {
        e.printStackTrace();
    }

    didFinally = true;

    LOGGER.info(Log("Fin."));
    System.exit(0);
}