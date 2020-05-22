StringBuilder sb = new StringBuilder(); 
            for (String s : b)
            {
                sb.append(s);
                sb.append("\t");
            }

            //Sorting the list
            Listeners.test.log(LogStatus.INFO,"--- List---");
            Listeners.test.log(LogStatus.INFO,sb.toString());