import java.util.*;

public class DNASequence
{
  private String DNASequence = null; //create a private static variable that can be accessed

  public static void main(String[] args)
  {
    System.out.println("Please input a sequence of DNA: ");
    DNASequence dnaS = new DNASequence((new Scanner(System.in)).nextLine().toUpperCase());
  }

  //Constructor Method that takes parameter a string and checks to see if its only A, T, C, G.
  public DNASequence(String DNAStrand) throws IllegalArgumentException
  {
    if (DNAStrand.matches("^[ATCG]+$"))
    {
      DNASequence = DNAStrand;
    }
    else
    {
      throw new IllegalArgumentException("DNA Sequences should only contain A, T, C, G charaters");
    }

  }

  /** Count each letter in the string */
  public int[] countLetters() throws IllegalArgumentException
  {
    int[] counts = new int[4];

    if (DNASequence != null)
    {
      for (int i = 0; i < DNASequence.length(); i++)
      {
        switch (DNASequence.charAt(i))
        {
          case 'A':
            counts[0]++;
            break;
          case 'T':
            counts[1]++;
            break;
          case 'C':
            counts[2]++;
            break;
          case 'G':
            counts[3]++;
            break;
          default:
            throw new IllegalArgumentException("DNA Sequences should only contain A, T, C, G charaters, found: " + DNASequence.charAt(i));
        }
      }
    }

    return counts;
  }

  //Method that just returns the stored sequence
  public String toString()
  {
    return DNASequence;
  }

  private char NucleotideBaseCount(char BaseCount){//Method to count bases
    return 'a'; // replace with real implementation
  }

  private boolean isSubsequenceOf(String DNAStrand)
  {
    return false; // repalce with real implementation
  }
}