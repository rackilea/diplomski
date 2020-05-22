String input = ">gi|58445847s cyclin-dependent kinase inhibitor 1B (p27, Kip1) (CDKN1B), mRNA\n"
             + "ATGTCAAACGTGCGAGTGTCTAACGGGAGCCCTAGCCTGGAGCGGATGGACGCCAGGCAGGCGGAGCACC\n"
             + "GCCCAAGAAGCCTGGCCTCAGAAGACGTCAAACGTAA\n"
             + "\n"
             + ">gi|584458479:571-1167 Homo sapiens 1B (p27, Kip1) (CDKN1B), mRNA\n"
             + "ATGTCAAACGTGCGAGTGTCTAACGGGAGCCCTAGCCTGGAGCGGATGGACGCCAGGCAGGCGGAGCACC\n"                   
             + "ACAAAAGAGCCAACAGAACAGAAGAAAATGTTTCAGACGGTTCCCCAAATGCCGGTTCTGTGGAGCAGAC\n"
             + "GCCCAAGAAGCCTGGCCTCAGAAGACGTCAAACGTAA\n";

Pattern p = Pattern.compile("^[ACTG]+(?:\\n[ACTG]+)*$", Pattern.MULTILINE);

Scanner s = new Scanner(input);
s.useDelimiter("\n");   

while(s.hasNext()) {
    System.out.println(s.findWithinHorizon(p, 0) + "\n");
}