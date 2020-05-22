for (int i = (curPersonFFTData.length / 64); i < (curPersonFFTData.length / 40); i++) {
            double rr = (curPersonFFTData[i].getReal());
            double ri = (curPersonFFTData[i].getImaginary());

            magnitudeCurPersonFFTData[i] = Math.sqrt((rr * rr) + (ri * ri));
            ds.addValue(magnitudeCurPersonFFTData[i]);
        }