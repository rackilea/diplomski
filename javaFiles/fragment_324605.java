import java.io.*;  

    class Test {
    public static void main(String args[]) throws IOException {
        DataInputStream dis = new DataInputStream(System.in);
        String name[] = new String[10];
        float s1[] = new float[10];
        float s2[] = new float[10];
        float s3[] = new float[10];
        float s4[] = new float[10];
        float tot[] = new float[10];
        float avrg[] = new float[10];
        float rankAvg[] = new float[10];
        int rank[] = new int[10];
        float total = 0;
        float avg = 0;

        for (int i = 0; i < 4; i++) {

            total = 0;
            avg = 0;
            System.out.println("Enter Name : ");
            String j = dis.readLine();
            name[i] = j;
            System.out.println("Enter Mark1 : ");
            String y = dis.readLine();
            float x = Float.parseFloat(y);
            s1[i] = x;
            System.out.println("Enter Mark2 : ");
            String n = dis.readLine();
            float m = Float.parseFloat(n);
            s2[i] = m;
            System.out.println("Enter Mark3 : ");
            String v = dis.readLine();
            float u = Float.parseFloat(v);
            s3[i] = u;
            System.out.println("Enter Mark4 : ");
            String a = dis.readLine();
            float b = Float.parseFloat(a);
            s4[i] = b;
            total = x + m + u + b;
            tot[i] = total;
            avg = total / 4;
            avrg[i] = avg;
            rankAvg[i]= avrg[i];
        }

        for(int i=0; i<4; i++){

            for(int j=i+1;j<4;j++){

                if(rankAvg[i] < rankAvg[j]){
                    float t = rankAvg[j];
                    rankAvg[j] = rankAvg[i];
                    rankAvg[i] = t;
                }

            }
        }

        System.out.println();
        System.out.println("Name" + "\t" + "Sub_1" + "\t" + "Sub_2" + "\t" + "Sub_3" + "\t" + "Sub_4" + "\t" + "Total" + "\t" + "Avg" + "\t" + "Rank");
        System.out.println();

        for (int k = 0; k < 4; k++) {

            System.out.println(name[k] + "\t" + s1[k] + "\t" + s2[k] + "\t" + s3[k] + "\t" + s4[k] + "\t" + tot[k] + "\t" + avrg[k] + "\t" + findRank(avrg, rankAvg, k));
        }

        System.out.println();
    }

    public static int findRank(float[] avrg, float[] rankAvg, int k){
        int rank=0;
        for(int i=0; i<4; i++){
            if(avrg[k] == rankAvg[i]){
                rank=i+1;
            }
        }
        return rank;
    }
}