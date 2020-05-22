if (menuOption == 5) {

                        double sum = 0;
                        for(int i = 0; i < listOfLogs.size() ; i++){
                        sum += listOfLogs.get(i).getHours();
                        }
                        return sum;

                    }