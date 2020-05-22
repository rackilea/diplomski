public static int distance(unsigned char hash1[], unsigned char hash2[], int len1, len2) {
    int distance = 0;
    for (int i = 0; i < len1 && i < len2; i++)
    {
        distance += ((hash2[i] & 0xFF) - (hash1[i] & 0xFF))*
                    ((hash2[i] & 0xFF) - (hash1[i] & 0xFF));
    }
    return distance;
}