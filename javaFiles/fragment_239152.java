//in setup()
fftLeft  = new FFT( player.bufferSize(), player.sampleRate() );
fftRight = new FFT( player.bufferSize(), player.sampleRate() );
//in draw()
fftLeft.forward(player.left);
fftRight.forward(player.right);