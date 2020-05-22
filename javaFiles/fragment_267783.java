result.forEach((key,value)->{
File newFile = new File(key+".csv");
BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
 values.forEach(order->{
         StringBuilder builder = new StringBuilder();
         builder.append(order.getId()+",");
         builder.append(order.getDates()+",");
         builder.append(order.getCountry()+",");
         builder.append(order.getValues()+",");
         writer.write(builder.toString());
         writer.newLine();
        };
         writer.flush();
         writer.close();
   });