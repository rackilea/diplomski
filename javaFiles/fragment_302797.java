class Bot_PageTrack extends PageTrack {
    public Bot_PageTrack(PageTrack pt) {
        for (Field field : PageTrack.class.getDeclaredFields()) {
            // this.field = pt.field
            try {
                field.set(this, field.get(pt));
            } catch (IllegalAccessException e) {
                throw new IllegalAccessError(e.getMessage());
            }
        }
    }
}