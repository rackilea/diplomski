public class FindMultiGenes4 {
    private static final String GENE_PREFIX = "ATG";
    private static final String[] GENE_SUFFIXES = {"TGA", "TAA", "TAG"};

    public int findStopIndex(String dna, int index) {
        int minStop = dna.length();
        for(String suffix : GENE_SUFFIXES) {
            int stop = -1;
            int localIndex = index;
            do{//repeating if the match found is not multiple of 3
                stop = dna.indexOf(suffix, localIndex);
                if(stop == -1) {
                    stop = dna.length();
                    break;
                }
                localIndex = stop + 3;
            } while( (stop - index) % 3 != 0);

            if(minStop > stop) {
                minStop = stop;
            }
        }
        return minStop + 3;
    }

    public void printAll(String dna) {
        String localDna = dna.toUpperCase();
        int index = 0;
        while(index != -1 && index + 3 < localDna.length()) {
            index = localDna.indexOf(GENE_PREFIX, index);
            if(index == -1) {
                break;
            }
            int stop = findStopIndex(localDna, index + 3);
            if(stop < dna.length()) {
                System.out.println("From " + (index) + " to " + stop
                        + " Gene: " + dna.substring(index, stop));
            }
            index = stop;
        }
    }

    public static void main(String[] args) {

        FindMultiGenes4 FMG = new FindMultiGenes4();

        String[] dnaSamples = {"CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA",
                "catgtaatagatgaatgactgatagatatgcttgtatgctatgaaaatgtgaaatgaccca",
                "cAtGtAaTaGaTgAaTgAcTgAtAgAtAtGcTtGtAtGcTaTgAaAaTgTgAaAtGaCcCa",
                "ATGAAATGAAAA",
                "ccatgccctaataaatgtctgtaatgtaga"};

        for(String dna : dnaSamples) {
            System.out.println("DNA: " + dna);
            FMG.printAll(dna);
            System.out.println("");
        }
    }
}