import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindMultiGenes5 {
    /*(?i) : Case insensitive match
     * ATG : Starts with ATG
     * (\\w{3})*? : smallest string with length multiple of 3
     * (TGA|TAA|TAG) : one of TAG, TAA or TAG
     */
    private static final String GENE_REGEX = "(?i)ATG(\\w{3})*?(TGA|TAA|TAG)";

    public void regexMatch(String dna) {
        Matcher matcher = Pattern.compile(GENE_REGEX).matcher(dna);
        while(matcher.find()) {
            System.out.println("From " + matcher.start() + " to " + matcher.end() + " Gene: " + matcher.group());
        }
    }

    public static void main(String[] args) {

        FindMultiGenes5 FMG = new FindMultiGenes5();

        String[] dnaSamples = {"CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA",
                "catgtaatagatgaatgactgatagatatgcttgtatgctatgaaaatgtgaaatgaccca",
                "cAtGtAaTaGaTgAaTgAcTgAtAgAtAtGcTtGtAtGcTaTgAaAaTgTgAaAtGaCcCa",
                "ATGAAATGAAAA",
                "ccatgccctaataaatgtctgtaatgtaga"};
        /*String[] dnaSamples = {"ATGaaabbbATGTGATAATGA".toLowerCase()};*/

        for(String dna : dnaSamples) {
            System.out.println("DNA: " + dna);
            FMG.regexMatch(dna);
            System.out.println("");
        }
    }
}