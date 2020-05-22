Collections.shuffle(MyList);

for(int i=0; i<MyList.size(); i++){
    System.out.println(MyList.get(i).getQuestion();

    Answer[] answers=new Answer[3];
    int correct=(int)(Math.random()*3);
    answers[correct]=MyList.get(i).getAnswer();

    int j=i, k=i;

    while( j==i ){
        j = (int)(Math.random()*MyList.size());
    }
    answers[(correct+1)%3] = MyList.get(j).getAnswer();

    while( k==i || k==j ){
        k=(int)(Math.random()*MyList.size());
    }
    answers[(correct+2)%3] = MyList.get(k).getAnswer();

    System.out.println("Answers:");
    for(int t=0;t<3;t++){
        System.out.println(answers[t]);
    }
}