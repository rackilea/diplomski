for(int i = 0; i< 10; i++){
     final int j = i;
     correct = active
         .stream()
         .filter(f-> f.getAnswerScore().get(j).getStatus().equals(AnswerStatus.ANSWERED_CORRECT))
         .count();
}