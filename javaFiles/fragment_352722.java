switch(menu)
{
    case 1 : 
        takeQuiz();
        break;
    case 2 :
        quizResults();
        break;
    case 3 :
        performanceComment();
        break;
    case 4 : 
        exit(); 
        break; // Do not need break if exit() used `System.exit(0)`
    case default: // Switch statements should include a `default` declaration for what to do when no cases are valid
        exit();
        break;
}