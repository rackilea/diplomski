public int compareTo(FitnessScore o){
    if(this.overall<o.overall)
          return -1;
    else if(o.overall<this.overall)
          return 1;
    return 0;
}