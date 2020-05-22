**Pseudo code**

for i = 0 to numSamplesInWave-1 do
begin
  theta = i / numSamplesInWave;
  wave = getWave(theta);
  currentAmplitude = applyLowPassFilter(TargetAmplitude);   
  Sample[i] = wave * currentAmplitude;
end;