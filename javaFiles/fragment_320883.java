/**
 * For the thread: http://stackoverflow.com/questions/35110522/need-help-implementing-matrix-rotation-in-java-for-cipher
 * 
 * @author Riley C
 * @version 1/30/16
 */
public class Cipher
{
    // instance variables
    private String text;
    private String[] matrix;
    private String[] encodedMatrix;

    /**
     * Constructor for objects of class Cipher
     */
    public Cipher(String text)
    {
        this.text = text;
        matrix = new String[text.length()];
        for (int i = 0; i < matrix.length; i++) // Sets each point of the matrix array to binary string
        {
            matrix[i] = "0" + Integer.toBinaryString(text.charAt(i));
            System.out.println(matrix[i]);
        }

        encodedMatrix = new String[8]; // Needs to hold 8 slots
        for (int i = 0; i < 8; i++) // Will reverse the matrix counter clockwise...
        {
            encodedMatrix[i] = "";
            for (int j = 0; j < matrix.length; j++)
                encodedMatrix[i] += matrix[j].charAt(7 - i);
            System.out.println(encodedMatrix[i]);
        }
    }

    // getters and setters
    public String getText() {return text;}
    public String[] getMatrix() // Making dat deep copy
    {
        String[] returnMatrix = new String[this.matrix.length];
        for (int i = 0; i < returnMatrix.length; i++)
            returnMatrix[i] = this.matrix[i];
        return returnMatrix;
    }
    public String[] getEncodedMatrix() // ...
    {
        String[] returnMatrix = new String[this.encodedMatrix.length];
        for (int i = 0; i < returnMatrix.length; i++)
            returnMatrix[i] = this.encodedMatrix[i];
        return returnMatrix;
    }
}