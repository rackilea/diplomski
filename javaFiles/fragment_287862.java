for(int i = 0; i < 26; i++) { 
    totalCount += count[i]; 
} 
System.out.println(totalCount);  

System.out.println(" Letter Occurrences Frequency"); 

System.out.println("--------------------------------");     
for(int i = 0; i < 26; i++) { 
    frequency[i] = ((double)count[i] / (totalCount + 1)) * 100;
    System.out.println(" " + letter[i] + "\t " + count[i] + "\t " + df.format(frequency[i])); 
}