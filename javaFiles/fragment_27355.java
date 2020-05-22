String line = bufferedReader.readLine();

while (line != null) {

   String[] data         =  line.split("\\t+");
   String   name         =  data[0];
   String   credits      =  data[2];
   String   description  =  data[3];
   String   professor    =  data[11];

   ClassInfo ci = new ClassInfo(name, credits, description, professor);
   classInfoList.add(ci);

   line = bufferedReader.readLine();
}