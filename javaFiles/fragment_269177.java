float v = userVolume();

if (v < SOFT_CUTOFF)
    color = interpolateColor(SILENT_COLOR, SOFT_COLOR, v/SOFT_CUTOFF);
else if (v < NORMAL_CUTOFF)
    color = interpolateColor(SOFT_COLOR, NORMAL_COLOR, (v-SOFT_CUTOFF)/(NORMAL_CUTOFF-SOFT_CUTOFF));
else
    color = interpolateColor(NORMAL_COLOR, LOUD_COLOR, (v-NORMAL_CUTOFF)/(1-NORMAL_CUTOFF));