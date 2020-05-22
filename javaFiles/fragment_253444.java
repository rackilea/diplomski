public ListItem duplicate() {
    if (next == null) {
        // base case: last item in the chain
        return new ListItem(this.number, null);
    }
    else {
        // start by duplicating the rest of the chain:
        ListItem newNext = next.duplicate();
        return new ListItem(this.number, newNext);
    }
}