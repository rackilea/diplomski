private int getRakeConfigForPatch(int patchId) {
    if (patchId >= 8550 && patchId <= 8557) {
        return patchId - 8550 + 708; // or patchId - 7842 for short, but less clear
    }
    return -1;
}