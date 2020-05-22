private class BallsComparator implements Comparator<Ball>
{
    public int compare(Ball o1, Ball o2)
    {
        return new Integer(o1.getWeight()).compareTo(o2.getWeight);
    }
}

Collections.sort(myBallsList, new BallsComparator());