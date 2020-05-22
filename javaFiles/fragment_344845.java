String dna = "acagatgaaggaggacgcgcccccgccgctgtcctgcgcctcagccatcctatgagacgg";

Pattern p = Pattern.compile("(gct)|(gcc)|(gca)|(gcg)");
Matcher m = p.matcher(dna);

int count = 0;
while(m.find()) {
  count ++;
}