float maxVal = Math.max(Math.abs(fftReal[i]), Math.abs(fftImag[i]));
if (maxVal != 0.0f) { // prevent divide-by-zero
    // Normalize
    fftReal[i] = fftReal[i] / maxVal;
    fftImag[i] = fftImag[i] / maxVal;
}

fftCurr[i] = scale * (float)Math.log10(fftReal[i]*fftReal[i] + fftImag[i]*fftImag[i]);
// ...