int totalPayloadSize = payload1 + payload1 + .......;
int totalUploadedSize = 0;
float globalUploadedPercentace = 0;

void updateLoop(int uploadedBytes){
    totalUploadedSize += uploadedBytes;
    globalUploadedPercentace = (totalUploadedSize * 100 * 1f)/totalPayloadSize;

}