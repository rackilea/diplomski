if(info[1].matches(numberforvote)){
            all="VOTED"+"/"+info[1]+"/"+info[2]+"/"+info[3]+"/"+info[4]+"/"+info[5]+"/"+info[6]+"/"+info[7]+"/"+info[8]+"/"+info[9]+"/"+info[10]+"/"+info[11]+"/"+info[12];
            outfile.println(all);
       }
      else{
            outfile.println(line); // this will write the "unchanged" lines
       }

        outfile.flush();