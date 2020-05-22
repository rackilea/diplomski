public int compareTo(Student another)
{
    if (this.score > another.score)
        return -1;
    if (this.score < another.score) 
        return 1;
    else
        return 0;
}