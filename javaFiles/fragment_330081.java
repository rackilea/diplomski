public ArrayList<detailTom>  read() 
{
   ArrayList<detailTom> tomData = null;
   try 
   {
       /*System.out.println("Hello");*/
       BufferedReader in = new BufferedReader(new FileReader("G:/sample.txt"));
       String data;
       ArrayList <String> list = new ArrayList<String>();
       ArrayList<String> tomList= new ArrayList<String>();
       tomData  = new ArrayList<detailTom>();

       while((data= in.readLine())!=null)
       {
           /*System.out.println(data);*/
           String[] splits=data.split(" ");
           for(int i=0;i<splits.length;i++)
           {
                 if (splits[i].equals("tom"))
                 {
                       detailTom dummy= new detailTom();
                        dummy.name="tom";
                        dummy.mark1=Integer.parseInt(splits[1]);
                        dummy.mark2=Integer.parseInt(splits[2]);
                        dummy.mark3=Integer.parseInt(splits[3]);
                        dummy.mark4=Integer.parseInt(splits[4]);
                        dummy.mark5=Integer.parseInt(splits[5]); 

                        tomData.add(dummy);

                 }
           }

       }

   }

   catch (FileNotFoundException ex) 
   {
       Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
   } catch (IOException ex) 
   {
       Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
   }
   return tomData;


}