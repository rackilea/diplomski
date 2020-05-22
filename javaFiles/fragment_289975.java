String myfloat = "0.0120";

String [] sig_figs = myfloat.split("(^0+(\\.?)0*|(~\\.)0+$|\\.)");

int sum = 0;

for (String fig : sig_figs)
{
    sum += fig.length();
}

return sum;