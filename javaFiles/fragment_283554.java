String test = "15 hour 10 min";
    String[] testArray = test.split(" ");
    long additionalDuration = 0;
    for(int i = 0; i < testArray.length; i+=2) {
        switch(testArray[i+1].toLowerCase()) {
            case "day":
            case "days":
                additionalDuration += Integer.parseInt(testArray[i]) * (1000 * 60 * 60 * 24);
                break;
            case "hour":
            case "hours":
                additionalDuration += Integer.parseInt(testArray[i]) * (1000 * 60 * 60);
                break;
            case "minute":
            case "minutes":
                additionalDuration += Integer.parseInt(testArray[i]) * (1000*60);
                break;
            default:
                System.out.println("Could not parse unit: \""+testArray[i+1]+"\"");
        }
    }
    Date futureDate = new Date(new Date().getTime() + additionalDuration);