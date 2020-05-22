Timestamp stamp = new Timestamp(Integer.valueOf(date[0]).intValue() - 1900, 
            Integer.valueOf(date[1]).intValue(), 
            Integer.valueOf(date[2]).intValue(), 
            Integer.valueOf(time[0]).intValue(), 
            Integer.valueOf(time[1]).intValue(), 
            Integer.valueOf(time[2].split("\\.")[0]).intValue(), 
            Integer.valueOf(time[2].split("\\.")[1]).intValue());