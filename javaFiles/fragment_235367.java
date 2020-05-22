@Override
public String generate() {
    this.end = this.files.size();
    ForkJoinPool pool = new ForkJoinPool();
    pool.execute(this);
    return this.join(); 
}