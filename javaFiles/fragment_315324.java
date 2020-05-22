@Override
public boolean equals(Object obj) {
    boolean eq = false;
    if (obj != null && obj instanceof YOURCLASS) {
        eq = this.getId().equals((YOUCLASS)obj.getId());
    }
}