String AdsIds[]=new String[6];
String EnTitle[]=new String[6];
String AdsTemproryData[]=new String[6];
String BineryTemprory[]=new String[2];
public void sieve(String Hash){         
            AdsTemproryData=Hash.split("/");
            for(int i=0;i<=5;i++){
                BineryTemprory= AdsTemproryData[i].split("\\*");
                AdsIds[i]=BineryTemprory[0];
                EnTitle[i]=BineryTemprory[1];
            }