FileWriter writer = new FileWriter(outPutFile);
             br = new BufferedReader(new FileReader(csvFileToRead));
             writer.append("[");
             while ((line = br.readLine()) != null) 
              {
                String[] products = line.split(splitBy);
                writer.append(" {proximity__c= " + products[0] + " , longitude__c="+products[1] +" , latitude__c=" + products[2]  + "},");
                writer.append("\n");     
              }
  writer.append("]");
  writer.flush();
  writer.close();