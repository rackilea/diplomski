double discountedmNIP = mNI - ((mNI/100)*10);
    int mNIC2 = (mNIC % 10);
    double mNIC2disc = (mNI * mNIC2);
    double discountedmNI = (mNI - ((mNI/100)*10)) * (mNIC - mNIC2);


    if(mNIC >= 10){

        System.out.println(discountedmNIP + " " + (mNIC - mNIC2) + " " + discountedmNI );
        System.out.println(mNI + " " + mNIC2 + " " + mNIC2disc);

    }



    else{

        System.out.print(mNI + " " + mNIC);
        System.out.print(mNI * mNIC);


    }

    double sum = (mNI + discountedmNI + discountedRh + rH);

    System.out.println('\t');
    System.out.println("Total order cost " + sum);