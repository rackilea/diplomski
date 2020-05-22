//edited to resolve issue brought up in comments
if (counter < limit) {
    while (counter < limit + inc) {
        //until counter is bigger than limit, count up by inc
        counter += inc;
        System.out.println(counter);
    }
} else if (counter > limit) {
    while (counter > limit - inc) {
        //until counter is smaller than limit, count down by inc
        counter -= inc;
        System.out.println(counter);
    }
}