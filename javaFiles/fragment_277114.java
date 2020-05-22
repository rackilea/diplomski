vtlen=0
for(int i=0; i<vt.length; i++)
{
    vtlen+=vt[i]*vt[i];
}
vtlen=sqrt(vtlen);
for(int i=0; i<vt.length; i++)
{
    vt[i] = (alpha * denom + (1 - alpha) * denom_best) * (v_hat[i] / vtlen);
}