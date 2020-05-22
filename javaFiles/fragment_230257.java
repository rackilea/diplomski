String s1 = "Inägogatan 23C (Göteborg) 6210 kr/mån, 69.0 m², 3 rum Eklandagatan 70B (Göteborg) 5594 kr/mån, 57.5 m², 3 rum Uddeholmsgatan 3 D . (Göteborg) 4959 kr/mån, 61.0 m², 3 rum";
String s2 = "Status: Visning påbörjad Status: Visning påbörjad Status: Visning avslutat";

String[] array1=s1.split("(?<=, 3 rum)\\s");
String[] array2=s2.split("\\s(?=Status:)");

List<String> result = new ArrayList<>();
for (int i=0; i<array1.length; i++){
    result.add(array1[i]+" "+array2[i]);
}

System.out.println(result);