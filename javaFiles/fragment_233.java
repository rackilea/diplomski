@Override
public int getItemCount() {
    if (matches != null) {
        return matches.size();
    } else {
        return 0;
    }
}