class BaseBehavior implement Behavior {
    public Behavior with(final Context context) {
        return new BaseBehavior(context);
    }

    public Behavior where(final View view) {
        return new BaseBehavior(view);
    }
}

class AnotherBehavior implement Behavior {
    BaseBehavior base;    

    AnotherBehavior(BaseBehavior base) {
        this.base = base;
    }

    public Behavior with(final Context context) {
        return base.with(context);
    }

    public Behavior where(final View view) {
        return base.with(view);
    }        
}