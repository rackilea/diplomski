int count = 0;
double total = 0;
String word = wordFile.nextLine();

while(movieReview.hasNext()){
    reviewScore = movieReview.nextInt();
    reviewText = movieReview.nextLine();

    if (reviewText.contains(word)) {
        count++;
        total = total + reviewScore;
    }
}
double average = (total / count);
System.out.println(average);