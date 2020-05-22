while (!status1 || !status2 /* || !status3 || and so on*/) {
    boolean do_break=false;
    if (!status1) {
        jTextField1.setForeground(Color.red);
        do_break=true;
    } 
    if (!status2) {
        jTextField2.setForeground(Color.red);
        do_break=true;
    }
/*    if (!status3) {
        jTextField3.setForeground(Color.red);
        do_break=true;
    }*/
    if(do_break) break;

    here_the_part_that_you_omitted_from_the_question();//...
}