boolean[] newbirds = {false, true, true};
            StringBuilder sb = new StringBuilder();
            for(boolean bird : newbirds){
                sb.append(bird? "yes " : "no "); 
            }
            System.out.println(sb.toString());