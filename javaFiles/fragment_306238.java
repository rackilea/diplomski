interface IComparer<T> {
    boolean areDifferent (T first, T second);
}

class FontComparer implements IComparer<Font> {
    @Override
    public boolean areDifferent(Font first, Font second) {
        // Compare fonts start
        // ..
        // Compare fonts end
        return new BorderComparer().areDifferent(first.getBorder(), second.getBorder());
    }
}


class BorderComparer implements IComparer<Border> {

    @Override
    public boolean areDifferent(Border first, Border second) {
        //Do border comparison alone
        return false;
    }
}