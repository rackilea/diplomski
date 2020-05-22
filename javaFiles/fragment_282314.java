import java.util.Random;

class svg{
    public static void main(String[] args){
        //use slashQuote to stand for \" in order to avoid confusing when modifying svg codes.
        String slashQuote="\"";
        System.out.format("<?xml version=%s1.0%s standalone=%sno%s?>\n", 
            slashQuote,slashQuote,slashQuote,slashQuote);
        System.out.format("<!DOCTYPE svg PUBLIC %s-//W3C//DTD SVG 1.1//EN%s\n%shttp://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd%s>\n",
            slashQuote,slashQuote,slashQuote,slashQuote);
        System.out.format("<svg height=%s800%s width=%s800%s xmlns=%shttp://www.w3.org/2000/svg%s version=%s1.1%s>\n",
            slashQuote,slashQuote,slashQuote,slashQuote,slashQuote,slashQuote,slashQuote,slashQuote);
        aliens();
        System.out.println("</svg>");
    }


    //Most of works were done in this function. It prints all aliens.
    public static void aliens(){
        //use slashQuote to stand for \" in order to avoid confusing when modifying svg codes.
        String slashQuote="\"";

        //This loop generates different aliens (because of randomColor) verticlely. It is looping 1*8 aliens to get 8*8 aliens. 
        for(int i=0; i<=800; i+=100){

            //get 7 colors by calling color() function for 7 times. The number is 7 because there will be 7 different color in one alien.
            String randomColor1 = color();
            String randomColor2 = color();
            String randomColor3 = color();
            String randomColor4 = color();
            String randomColor5 = color();
            String randomColor6 = color();
            String randomColor7 = color();

            //This loop generates identicle aliens horizontaly. It is looping a 1*1 alien to get 1*8 aliens.
            //It will not affected by "String randomColorN = color();" because I only defined colors in outer loop.
            for(int j=0;j<=800;j+=100){
                //Here is my alien!!!!!!!!!!!!!!!!!!!!!
                System.out.format("<ellipse cx=%s%d%s cy=%s%d%s rx=%s10%s ry=%s30%s stroke=%s"+randomColor1+
                    "%s stroke-width=%s3%s fill=%s"+randomColor2+"%s />\n", 
                    slashQuote,50+j,slashQuote,slashQuote,60+i,slashQuote,slashQuote,slashQuote,slashQuote,
                    slashQuote,slashQuote,slashQuote,slashQuote,slashQuote,slashQuote,slashQuote,slashQuote);

                System.out.format("<line x1=%s%d%s y1=%s%d%s x2=%s%d%s y2=%s%d%s stroke=%s"+randomColor3+
                    "%s stroke-width=%s5%s />\n", 
                    slashQuote,50+j,slashQuote,slashQuote,50+i,slashQuote,slashQuote,50+j,slashQuote,
                    slashQuote,30+i,slashQuote,slashQuote,slashQuote,slashQuote,slashQuote);

                System.out.format("<line x1=%s%d%s y1=%s%d%s x2=%s%d%s y2=%s%d%s stroke=%s"+randomColor4+
                    "%s stroke-width=%s3%s />\n", 
                    slashQuote,40+j,slashQuote,slashQuote,60+i,slashQuote,slashQuote,20+j,slashQuote,
                    slashQuote,50+i,slashQuote,slashQuote,slashQuote,slashQuote,slashQuote);
                System.out.format("<circle cx=%s%d%s cy=%s%d%s r=%s3%s fill=%s"+randomColor5+"%s />\n", 
                    slashQuote,36+j,slashQuote,slashQuote,15+i,slashQuote,slashQuote,slashQuote,slashQuote,slashQuote);
                System.out.format("<rect x=%s%d%s y=%s%d%s width=%s20%s height=%s20%s style=%sfill:"+randomColor6+
                    ";stroke-width:3;stroke:"+randomColor7+"%s/>\n\n",
                    slashQuote,40+j,slashQuote,slashQuote,10+i,slashQuote,slashQuote,slashQuote,slashQuote,
                    slashQuote,slashQuote,slashQuote);
            }
        }
    }

    //Generate a random number.
    public static String color(){
        Random randomGenerator = new Random();
        int r = randomGenerator.nextInt(256);
        int g = randomGenerator.nextInt(256);
        int b = randomGenerator.nextInt(256);
        /*#%02x%02x%02x converts the RGB color to the hexadecimal value. I tried to use RGB color at first 
        but it doesn't work in svg. Then I found this method in stack overflow. Here is the link: 
        http://stackoverflow.com/questions/3607858/how-to-convert-a-rgb-color-value-to-an-hexadecimal-value-in-java*/
        return String.format("#%02x%02x%02x",r,g,b);
    }
}