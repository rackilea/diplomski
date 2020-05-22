class BestGrades {
public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int grade[] = new int[6];
        int best[] = new int[3];

        System.out.println("Enter the student's grade...");

        for(int i = 0; i < grade.length; i++){

                grade[i] = sc.nextInt();

                boolean better = false;
                int lowerIndex = 0;

                for(int a = 0; a < best.length; a++){
                        if(grade[i] > best[a]){
                                better = true;
                        }
                        if(best[a] < best[lowerIndex]){
                            lowerIndex = a;
                        }
                }
                if(better){
                    best[lowerIndex] = grade[i];
                }
        }

        for(int i = 0; i < best.length; i++){
                System.out.println("Best degrees are: "+best[i]);
        }
    }
}