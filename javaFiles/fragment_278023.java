for(int i=0;i <score.length;i++) {

        sb.append(sentence[i]);
        sb.append(";");

        sb.append(score[i]);
        sb.append('\n');                
        //System.out.print(sb.toString()); to print values 
        //sb =new StringBuilder();
    }
    pw.write(sb.toString());
    pw.close();