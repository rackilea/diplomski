String grade = score > 100 || score < 0 ? "Enter Valid Number !" :
"Your Grade Is" + ((score <= 100 && score >= 85) ? "Excellent"
            : (score >= 75 && score < 85) ? "Very Good"
                    : (score >= 65 && score < 75) ? "Good"
                            : (score >= 50 && score < 65) ? "pass"
                                    : (score > 0 && score < 50) ? "Fail");
    System.out.println(">>>"+grade);