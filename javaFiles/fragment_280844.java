double targetRatio = Math.min((double)w/h, (double)h/w);//height & width of the screen
        List<Size> sizes //populated with supported height and width
    double ratioArray[];
    int i;
    for (i = 0; i <= sizes.size(); i++) 
    {
        double ratio = Math.min((double)sizes.get(i).width/sizes.get(i).height, (double)sizes.get(i).height/sizes.get(i).width);
        ratioArray[i] = Math.abs(ratio - targetRatio);
        // Math.min((double)sizes.get(i).width/w, (double)w/sizes.get(i).width);
        // Math.min((double)h/sizes.get(i).height, (double)sizes.get(i).height/h);
        //sizes.get(i).width
        //sizes.get(i).height

    }