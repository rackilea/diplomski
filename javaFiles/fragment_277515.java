public static void getCheckout(int score, int fav_double, ICheckOutEvent listener)
{
    if(score > 170) return;
    if(score == 170) listener.onCheckOut("T20 T20 Bull");

    ArrayList<Dart> darts = new ArrayList<Dart>();
    darts.add(new Dart(fav_double, 2));
    darts.add(new Dart(0,0));
    darts.add(new Dart(0,0));

    darts = getDarts(score, darts);

    if(darts != null) {
        listener.onCheckOut(toString(darts));
        return;
    }

    for(int dubble = 20 ; dubble >= 1 ; dubble--)
    {
        if(dubble == fav_double) continue;

        darts = new ArrayList<Dart>();
        darts.add(new Dart(dubble, 2));
        darts.add(new Dart(0,0));
        darts.add(new Dart(0,0));
        darts = getDarts(score, darts);

        if(darts != null){
            listener.onCheckOut(toString(darts));
            return;
        }
    }   
}

public static ArrayList<Dart> getDarts(int desired, ArrayList<Dart> score)
{
    Dart dart1 = canFinish(desired);
    if(dart1 != null){
        score.set(0, dart1);
        return score;
    }

    int rest = desired - score.get(0).value();
    Dart dart2 = canScore(rest);
    if(dart2 != null)
    {
        score.set(0, score.get(0));
        score.set(1, dart2);
        return score;
    }

    Dart temp = score.get(1);

    if(temp.increment())
    {
        rest = desired - score.get(0).value() - temp.value();
        score.set(0, score.get(0));
        score.set(1, temp);

        Dart dart3 = canScore(rest);
        if(dart3 != null)
        {
            score.set(2, dart3);
            return score;
        }

        if(rest > 60 && temp.increment()) 
            temp.estimate(rest / 2);

        score.set(1, temp);
        return getDarts(desired, score);
    }

    return null;
}

public static int eval(ArrayList<Dart> scores)
{
    int total = 0;
    for(Dart score : scores){
        total += score.value();
    }
    return total;
}

public static Dart canFinish(int points)
{
    switch(points)
    {
        case 2: return new Dart(1, 2);
        case 4: return new Dart(2, 2);
        case 6: return new Dart(3, 2);
        case 8: return new Dart(4, 2);
        case 10: return new Dart(5, 2);
        case 12: return new Dart(6, 2);
        case 14: return new Dart(7, 2);
        // etc. etc.
        case 40: return new Dart(20, 2);
        case 50: return new Dart(25, 2);
    }

    return null;
}

public static Dart canScore(int points)
{
    switch(points)
    {
        case 1: return new Dart(1, 1);
        case 2: return new Dart(2, 1);
        case 3: return new Dart(3, 1);
        // etc. etc.
        case 20: return new Dart(20, 1);
        case 21: return new Dart(7, 3);
        case 22: return new Dart(11, 2);
        //case 23: impossible
        case 24: return new Dart(12, 2);
        // etc. etc.
        case 57: return new Dart(19, 3);
        case 60: return new Dart(20, 3);
    }

    return null;
}