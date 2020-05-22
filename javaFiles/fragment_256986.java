// Movie:
@Override
public boolean equals(Object obj) {
    if (!(obj instanceof Movie)) return false;

    Movie that = (Movie) obj;

    return this.title.contains(that.title) || that.title.contains(this.title);
}