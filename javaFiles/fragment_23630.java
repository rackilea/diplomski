bw.write(t);
    //check if the end of t and the start of f do not have a ",". If neither has a comma then add one to the end of t
    if (t.endsWith(",") == false && f.startsWith(",") == false)
    {
        t = t + ",";
    }
    bw.write(f);