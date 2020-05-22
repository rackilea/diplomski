import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import cloud.CloudStructureData;
import cloud.Host;
import cloud.Instance;

public class CloudStructure {

    public static CloudStructureData readHost(String filePath)
    {
        String line = "";

        CloudStructureData cloudData = new CloudStructureData();

        FileReader fr;
        BufferedReader br;

        String[] HostID = null;
        String[] Slots = null;
        String[] DataCentre = null;

          try {
               fr = new FileReader(filePath);
               br = new BufferedReader(fr);

               while((line = br.readLine()) != null) 
               {   
                   HostID = line.split(",");
                   Slots = line.split(",");
                   DataCentre = line.split(",");                

                   Host host = new Host(HostID[0], Slots[1], DataCentre[2]);

                   cloudData.getHosts().put(HostID[0], host);
               }
              }
              catch(FileNotFoundException fN) {
               fN.printStackTrace();
              }
              catch(IOException e) {
               System.out.println(e);
              } 

         // output data the way you want...

         return cloudData;
    }   

    public static CloudStructureData readInstance(String filePath, CloudStructureData cloudData)
    {
        String line = "";

        FileReader fr;
        BufferedReader br;

        String[] InstanceId = null;
        String[] CustId = null;
        String[] HostId = null;

          try {
               fr = new FileReader(filePath);
               br = new BufferedReader(fr);

               while((line = br.readLine()) != null) 
               {   
                   InstanceId = line.split(",");
                   CustId = line.split(",");
                   HostId = line.split(",");                

                   Host hostObject = cloudData.getHosts().get(HostId[2]); // Host object or null if not found
                   Instance instanceObject = new Instance(InstanceId[0], CustId[1], hostObject);
                   cloudData.getInstances().put(InstanceId[0], instanceObject);
               }
              }
              catch(FileNotFoundException fN) {
               fN.printStackTrace();
              }
              catch(IOException e) {
               System.out.println(e);
              } 

              // output instances the way you want

              return cloudData;
    } 


    public static void main(String[] args) {

        CloudStructureData cloudData = readHost("C:\\tmp\\HostState.txt");
        cloudData = readInstance("C:\\tmp\\InstanceState.txt", cloudData);
        /*
         * All Instances are now linked with Host.  
         * You can loop and do whatever you want.
         */
        for (Map.Entry<String, Instance> currentEntry 
                : cloudData.getInstances().entrySet()) {
            Instance currentInstance = currentEntry.getValue();
            Host currentHost = currentInstance.getHost();
            // Now you have the current instance and its related host...
        }

    }
}