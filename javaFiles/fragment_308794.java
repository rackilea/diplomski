import java.text.DecimalFormat;

DecimalFormat df = new DecimalFormat( "00000000" );

int  n = 1000;

for (int i=0;i<n;i++)
{
    String sequence = df.format(i);
    System.out.println(sequence);
}