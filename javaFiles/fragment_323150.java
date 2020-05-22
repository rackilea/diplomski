public double pointsEarned() {
    if (this.finishOrder == 1) {
      return (this.time - 10);
    } else if (this.finishOrder == 2) {
      return (this.time - 7);
    } else if (this.finishOrder == 3) {
      return (this.time - 3);
    } else {
      return this.time;
    }
  }