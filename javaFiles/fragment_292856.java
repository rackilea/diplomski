public static void main(String[] args)
{
    double a = 0;
    double b = 0; 
    double c = 0;
    String[] resultA = null;
    String[] resultB = null;
    String[] resultC = null;
    String[] result = null;

    if(args.length > 0)
    {
        for(int i=0; i < args.length; i++)
        {   
            if(args[i].toUpperCase().startsWith("A"))   // Implemented startsWith() thanks to WChargin
            {
                resultA = args[i].split("=");   //Split by the delimter "="
                a = Double.parseDouble(resultA[1]);
            }
            else if(args[i].toUpperCase().startsWith("B"))
            {
                resultB = args[i].split("=");
                b = Double.parseDouble(resultB[1]);
            }
            else if(args[i].toUpperCase().startsWith("C"))
            {
                result = args[i].split("="); //We don't need C, split all of the arguments
                resultC = result[1].split(""); //This way we have an array of strings for each value to iterate through
                // The only problem with split("") is that we will get an empty string at the beginning of the array

                for(int j=1; j < resultC.length; j++)
                {
                    if(resultC[j].toUpperCase().startsWith("A"))
                    {
                        if(resultC[j+1].equals("+"))
                        {
                            if(resultC[j+2].toUpperCase().startsWith("A"))
                            {
                                c = a + a;
                                break;
                                // Once we get out answer, break otherwise we'll get a ArrayIndexOutOfBoundsException because the program will continue iterating
                            }
                            else if(resultC[j+2].toUpperCase().startsWith("B"))
                            {
                                c = a + b;
                                break;
                            }
                            else
                            {
                                System.out.println("Argument parse error");
                            }
                        }
                        else if(resultC[j+1].equals("-"))
                        {
                            if(resultC[j+2].toUpperCase().startsWith("A"))
                            {
                                c = a - a;
                                break;
                            }
                            else if(resultC[j+2].toUpperCase().startsWith("B"))
                            {
                                c = a - b;
                                break;
                            }
                            else
                            {
                                System.out.println("Argument parse error");
                            }
                        }
                        else if(resultC[j+1].equals("*"))
                        {
                            if(resultC[j+2].toUpperCase().startsWith("A"))
                            {
                                c = a * a;
                                break;
                            }
                            else if(resultC[j+2].toUpperCase().startsWith("B"))
                            {
                                c = a * b;
                                break;
                            }
                            else
                            {
                                System.out.println("Argument parse error");
                            }
                        }
                        else if(resultC[j+1].equals("/"))
                        {
                            if(resultC[j+2].toUpperCase().startsWith("A"))
                            {
                                c = a / a;
                                break;
                            }
                            else if(resultC[j+2].toUpperCase().startsWith("B"))
                            {
                                c = a / b;
                            }
                            else
                            {
                                System.out.println("Argument parse error");
                            }
                        }
                    }
                    else if(resultC[j].toUpperCase().startsWith("B"))
                    {
                        if(resultC[j+1].equals("+"))
                        {
                            if(resultC[j+2].toUpperCase().startsWith("A"))
                            {
                                c = b + a;
                                break;
                            }
                            else if(resultC[j+2].toUpperCase().startsWith("B"))
                            {
                                c = b + b;
                                break;
                            }
                            else
                            {
                                System.out.println("Argument parse error");
                            }
                        }
                        else if(resultC[j+1].equals("-"))
                        {
                            if(resultC[j+2].toUpperCase().startsWith("A"))
                            {
                                c = b - a;
                                break;
                            }
                            else if(resultC[j+2].toUpperCase().startsWith("B"))
                            {
                                c = b - b;
                                break;
                            }
                            else
                            {
                                System.out.println("Argument parse error");
                            }
                        }
                        else if(resultC[j+1].equals("*"))
                        {
                            if(resultC[j+2].toUpperCase().startsWith("A"))
                            {
                                c = b * a;
                                break;
                            }
                            else if(resultC[j+2].toUpperCase().startsWith("B"))
                            {
                                c = b * b;
                                break;
                            }
                            else
                            {
                                System.out.println("Argument parse error");
                            }
                        }
                        else if(resultC[j+1].equals("/"))
                        {
                            if(resultC[j+2].toUpperCase().startsWith("A"))
                            {
                                c = b / a;
                                break;
                            }
                            else if(resultC[j+2].toUpperCase().startsWith("B"))
                            {
                                c = b / b;
                                break;
                            }
                            else
                            {
                                System.out.println("Argument parse error");
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Argument error in C");
                        System.exit(1);
                    }
                }
            }
        }
    }
    else
    {
        System.out.println("Invalid number of arguments");
        System.exit(1);
    }

    System.out.printf("A: %f\nB: %f\nC: %f\n", a, b, c);
}