public Race(int number, int typeIndex, MyDate date) { 
    // TODO
    this.number = number;
    this.typeIndex = typeIndex;
    this.date = date;
    this.hasFinished = false;
    this.numberOfCompetitors = 0;
    this.competitors = new Competitor[MAX_COMPETITORS];

}