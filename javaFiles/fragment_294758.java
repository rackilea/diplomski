if (UseSSE < 4) {
  _cpuFeatures &= ~CPU_SSE4_1;
  _cpuFeatures &= ~CPU_SSE4_2;
}

if (UseSSE < 3) {
  _cpuFeatures &= ~CPU_SSE3;
  _cpuFeatures &= ~CPU_SSSE3;
  _cpuFeatures &= ~CPU_SSE4A;
}

if (UseSSE < 2)
  _cpuFeatures &= ~CPU_SSE2;

if (UseSSE < 1)
  _cpuFeatures &= ~CPU_SSE;