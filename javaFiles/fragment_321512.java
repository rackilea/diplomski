import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Rozwiazanie {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] splittedLinia = br.readLine().split((char) 32 + "");//moglaby byc " " ale tak na wszelki wypadek nie ma chuja zeby sie popierdolilo teraz nawet na linuxie
            int aktualnyWyraz = Integer.parseInt(splittedLinia[0]);//uwaga jakby cos nie gralo w sprawdzarce zmien typ na long
            int poprzedniWyraz = 0; 

            long podsumaRosnaca = aktualnyWyraz;
            long podsumaSpadajaca = aktualnyWyraz;

            int dlugoscRosnaca = 1;
            int dlugoscSpadajaca = 1;

            int maxDlugosc = 1;
            long maxPodsuma = aktualnyWyraz;

            int czyRosnacy = 0; // 0 -- nie znane (jezeli w poczatku wszystkie liczby sa rowne), 1 -- rosnacy, -1 -- spadajacy
            boolean rowny = false;
            System.out.println("akt: " + aktualnyWyraz + " dlR: " + dlugoscRosnaca + " podsumaR: " + podsumaRosnaca + " dlP: " + dlugoscSpadajaca + " podsumaP: " + podsumaSpadajaca);

            for (int i = 1; i < splittedLinia.length; i++) {
                poprzedniWyraz = aktualnyWyraz;
                aktualnyWyraz = Integer.parseInt(splittedLinia[i]);
                if (aktualnyWyraz == poprzedniWyraz) {
                    podsumaRosnaca += aktualnyWyraz;
                    podsumaSpadajaca += aktualnyWyraz;
                    dlugoscRosnaca++;
                    dlugoscSpadajaca++;
                    rowny = true;
                } else { // rozne liczby
                    if (aktualnyWyraz > poprzedniWyraz) { // rosnie
                        podsumaRosnaca += aktualnyWyraz;
                        dlugoscRosnaca++;      

                        if (rowny) {
                            dlugoscSpadajaca = 1;
                            podsumaSpadajaca = 0;
                            rowny = false;
                        }       
                        if (czyRosnacy < 0) {
                            if (dlugoscSpadajaca > maxDlugosc) {
                                maxDlugosc = dlugoscSpadajaca;
                                maxPodsuma = podsumaSpadajaca;
                            }
                            podsumaSpadajaca = 0;
                            dlugoscSpadajaca = 1;
                        }
                        czyRosnacy = 1;   
                    } else { // spada
                        podsumaSpadajaca += aktualnyWyraz;
                        dlugoscSpadajaca++; 

                        if (rowny) {
                            dlugoscRosnaca = 1;
                            podsumaRosnaca = 0;
                            rowny = false;
                        }
                        if (czyRosnacy == 1) {
                            if (dlugoscRosnaca > maxDlugosc) {
                                maxDlugosc = dlugoscRosnaca;
                                maxPodsuma = podsumaRosnaca;
                            }
                            podsumaRosnaca = 0;
                            dlugoscRosnaca = 1;
                        }  
                        czyRosnacy = -1;
                    }

                }
                System.out.println("akt: " + aktualnyWyraz + " dlR: " + dlugoscRosnaca + " podsumaR: " + podsumaRosnaca + " dlP: " + dlugoscSpadajaca + " podsumaP: " + podsumaSpadajaca);
            }


            System.out.println("maxDlugosc " + maxDlugosc + " maxPodsuma " + maxPodsuma);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}