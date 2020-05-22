double step = Fs/N; // 0.015621186;
double freq = 0;
double freqs[] = double[N/2];
for(int i=0;i<N/2-1;i++)
{
    re=fft[2*i];
    im=fft[2*i+1];

    magnitude[i]=Math.sqrt(re*re+im*im);
    freqs[i] = freq;

    freq = freq + step;
}