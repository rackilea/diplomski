while(fileName.hasNext())
 {
    String line =fileName.nextLine();
    String tramDetails[] = line.split("\\^");
    String suburbName = tramDetails[4];
    String roadName = tramDetails[3];

    if(suburbName.equals(suburbInput) && roadName.equals(roadInput))
    {

          String crossStreet = tramDetails[0];
          String stopNumber = tramDetails[1];
          int stopNumberInt = Integer.parseInt(stopNumber);
          String trackerID = tramDetails[2];
          int trackerIDInt = Integer.parseInt(trackerID);

          System.out.print("'Suburb': " + suburbName 
                            + " 'Road': " + roadName 
                            + " 'Cross Street': " + crossStreet   
                            + " 'Stop': " + stopNumberInt 
                            + " 'Tracker ID': " + trackerIDInt + "\n");
    }