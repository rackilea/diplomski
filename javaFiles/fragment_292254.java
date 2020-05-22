while (score != SENTINEL )
{
    total += score;
    count ++;
    if(score > maxGrade)
        maxGrade = score;
    if(score < minGrade)
        minGrade = score;
    System.out.print("Enter the next test score > ");
    score = scan.nextInt();
}