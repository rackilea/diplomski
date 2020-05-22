import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

    /*
     * Constructor just for test
     */
    Test()
    {
        Equation equation = getMembers("-3.2x - 5.6y + 34 = -10");

        System.out.print("Left members: ");
        for(EquationMember m : equation.leftMembers)
            System.out.print(m + " ");

        System.out.print("\nRight members: ");
        for(EquationMember m : equation.rightMembers)
            System.out.print(m + " ");
    }

    /*
     * Main method
     */
    public static void main(String args[])
    {
        new Test();
    }

    /*
     * Transforms a strings representation of an equation into an Equation class
     */
    Equation getMembers(String equationString)
    {
        Equation equation = new Equation();
        String eq = equationString.replace(" ", "");
        char[] charArray = eq.toCharArray();

        boolean isLeft = true;
        String lastMember = "";

        for(int i = 0; i < charArray.length; i++)
        {   
            if(charArray[i] == '-' || charArray[i] == '+' || charArray[i] == '=')
            {
                if(lastMember.length() > 0)
                {
                    EquationMember m = new EquationMember();
                    m.constant = Float.parseFloat(match("([-+]?[\\d\\.]+)[A-Za-z]?", lastMember, 1));
                    m.variable = match("[\\d\\.]+([A-Za-z]?)", lastMember, 1);

                    if(isLeft)
                        equation.leftMembers.add(m);
                    else
                        equation.rightMembers.add(m);
                }
                lastMember = charArray[i] == '=' ? "" : String.valueOf(charArray[i]);
            }
            else
            {
                lastMember += charArray[i];
            }

            if(charArray[i] == '=')
            {
                isLeft = false;
            }
        }

        EquationMember m = new EquationMember();
        m.constant = Float.parseFloat(match("([-+]?[\\d\\.]+)[A-Za-z]?", lastMember, 1));
        m.variable = match("[\\d\\.]+([A-Za-z]?)", lastMember, 1);
        equation.rightMembers.add(m);

        return equation;
    }

    /*
     * Performs a regex match
     */
    String match(String regexp, String text, int group)
    {
        Pattern p1 = Pattern.compile(regexp);
        Matcher m1 = p1.matcher(text);

        if(m1.find())
            return m1.group(group);
        else
            return null;
    }

    /*
     * Class that represents a single member inside an equation
     */
    class EquationMember
    {
        float constant;
        String variable;

        public String toString()
        {
            return constant + "" + variable;
        }
    }

    /*
     * Class that represents an entire equation
     */
    class Equation
    {
        ArrayList<EquationMember> leftMembers;
        ArrayList<EquationMember> rightMembers;

        Equation()
        {
            leftMembers = new ArrayList<EquationMember>();
            rightMembers = new ArrayList<EquationMember>();
        }
    }

}