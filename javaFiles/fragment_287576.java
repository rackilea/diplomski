int final_score = 0;
for(int i = 0; i < h; i++) {
    score_result = pArray[i] - hArray[i];
    final_score += score_result;
}
System.out.println(final_score);