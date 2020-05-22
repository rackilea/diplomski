void calculate() {
    answer=numValue[l-1];
    for(int i=0;i<l-1;i++) {

        int c;
        if(numValue[l-1-i]<numValue[l-i-2]) {
            c=numValue[l-2-i];
            answer+=c;
            System.out.println("+"+c+" Now : "+answer);
        } else {
            c=numValue[l-2-i];
            answer-=c;
            System.out.println("-"+c+" Now : "+answer);
        }
    }
}