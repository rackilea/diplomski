String myint = "000100101111220000020000";

String[] sig_figs = myint.split("(^0+|0+$)");

int sum = 0;

for(String fig : sig_figs)
{
    sum += fig.length();
}

return sum;